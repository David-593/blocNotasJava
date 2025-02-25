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
            || usuario.getUsuEstado() == null || usuario.getUsuClave() == null){
            throw new Exception("Estos campos son obligatorios");
        } 
        try {
            em.persist(usuario); 
        } catch (Exception e) {
           throw new Exception("Error al guardar en la base de datos" + e.getMessage()); 
        }
        
    }
    
    //delete
    public void deleteUser(Usuario usuario){
        em.remove(usuario);
    }

    //read user by id
    public Usuario getUserById(Long usuId){
        return em.find(Usuario.class, usuId);
    }
    
    //update
    public Usuario updateUser(Usuario usuario){
        return em.merge(usuario);
    }
}
