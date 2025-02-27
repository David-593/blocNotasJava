package com.company.blocNotas.service;


import com.mycompany.blocNotas.entities.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class usuarioService {
    
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    
    //create
    public void createUser(Usuario usuario) throws Exception{
        if (usuario.getUsuNombres() == null || usuario.getUsuApellidos() == null 
            || usuario.getUsuNacimiento() == null || usuario.getUsuEmail() == null 
            || usuario.getUsuClave() == null){
            throw new Exception("Estos campos son obligatorios");
        } 
        
        if (usuario.getUsuEstado() == null){
            usuario.setUsuEstado(true);
        }
            em.persist(usuario); 
        
    }
    
    //read user by id
    public Usuario getUserById(Long usuId) throws Exception{
        Usuario usuario = em.find(Usuario.class, usuId);
        if (usuario == null){
            throw new Exception("Usuario no encontrado");
        }
        return usuario;
    }
    
    //update
    public Usuario updateUser(Long usuId, Usuario usuarioActualizado) throws Exception{
        Usuario usuario = em.find(Usuario.class, usuId);
        if (usuario == null){
            throw new Exception("Usuario no encontrado");
        }
        if (usuarioActualizado.getUsuNombres() != null){
            usuario.setUsuNombres(usuarioActualizado.getUsuNombres());
        }
        if (usuarioActualizado.getUsuApellidos() != null){ 
            usuario.setUsuApellidos(usuarioActualizado.getUsuApellidos());
        }
        if (usuarioActualizado.getUsuNacimiento() != null){
            usuario.setUsuNacimiento(usuarioActualizado.getUsuNacimiento());
        }
        if (usuarioActualizado.getUsuEmail() != null){
            usuario.setUsuEmail(usuarioActualizado.getUsuEmail());
        }
        if (usuarioActualizado.getUsuEstado() != null){
            usuario.setUsuEstado(usuarioActualizado.getUsuEstado());
        }
        if(usuarioActualizado.getUsuClave() != null){
            usuario.setUsuClave(usuarioActualizado.getUsuClave());
        }
        return em.merge(usuario);
    }

    //delete
    public void deleteUser(Long usuId) throws Exception{
        Usuario usuario = em.find(Usuario.class, usuId);
        if (usuario == null){
            throw new Exception ("Usuario no encontrado");
        }
        em.remove(usuario);
    }
}
