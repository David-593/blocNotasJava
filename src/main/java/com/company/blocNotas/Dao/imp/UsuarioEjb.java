
package com.company.blocNotas.Dao.imp;

import com.company.blocNotas.Dao.itf.IUsuarioEjb;
import com.mycompany.blocNotas.entities.Usuarios;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless(name = "EJB_USUARIOS")
public class UsuarioEjb implements IUsuarioEjb{

    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    @Override
    public Usuarios createUsuario(Usuarios usuario) throws Exception {
        em.persist(usuario);
        return usuario;
    }

    @Override
    public Usuarios modifyUsuario(Usuarios usuario) throws Exception {
        if(!existById(usuario.getUsuId())){
            throw new EntityNotFoundException("Ningun usuario está asociado con ese ID");
        }
        return em.merge(usuario);
    }

    @Override
    public Usuarios deleteUsuario(Usuarios usuario) throws Exception {
        if(!existById(usuario.getUsuId())){
            throw new EntityNotFoundException("Ningun usuario está asociado con ese ID");
        }
        
        //Se asocia al em para evitar problemas
        em.merge(usuario);
        
        em.remove(usuario);
        return usuario;
    }

    @Override
    public Usuarios getUsuarioById(Usuarios usuario) throws Exception {
        if(!existById(usuario.getUsuId())){
            throw new EntityNotFoundException("Ningun usuario está asociado con ese ID");
        } 
        Usuarios user = em.find(Usuarios.class, usuario.getUsuId());
        return user;
    }

    @Override
    public boolean existById(Integer usuId) throws Exception {
        return em.find(Usuarios.class, usuId) != null;
    }

    @Override
    public List<Usuarios> getAllUsuarios() throws Exception {
        return em.createQuery("SELECT u FROM Usuarios u LEFT JOIN FETCH c.notaList", Usuarios.class)
                .getResultList();
    }
 
}
