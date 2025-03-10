package com.company.blocNotas.service;


import com.company.blocNotas.dto.usuarioDto;
import com.mycompany.blocNotas.entities.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class usuarioService {
    
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    
    //create
    public void createUser(Usuario usuario) throws Exception{
        try{
        if (usuario.getUsuNombres() == null || usuario.getUsuApellidos() == null 
            || usuario.getUsuNacimiento() == null || usuario.getUsuEmail() == null 
            || usuario.getUsuClave() == null){
            throw new Exception("Estos campos son obligatorios");
        } 
        
        if (usuario.getUsuEstado() == null){
            usuario.setUsuEstado(true);
        }
            em.persist(usuario); 
            
        } catch (IllegalArgumentException e) {
        System.err.println("Error de validacion: " + e.getMessage());
        } catch (Exception e) {
        System.err.println("Error inesperado al crear usuario: " + e.getMessage());
    
        }
    }
    
    //read user by id
    public usuarioDto getUserById(Long usuId) {
        try {
            Usuario usuario = em.find(Usuario.class, usuId);
            if (usuario == null) {
                throw new IllegalArgumentException("Usuario no encontrado");
            }
            return new usuarioDto(usuario);
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al obtener usuario: " + e.getMessage());
        }
        return null;
    }
    
    //read all users
    public List<Usuario> getAllUser(){
        return em.createQuery("SELECT c FROM Usuario c LEFT JOIN FETCH c.notaList", Usuario.class).getResultList();
    }
    
    //update
    public Usuario updateUser(Long usuId, Usuario usuarioActualizado) {
        try {
            Usuario usuario = em.find(Usuario.class, usuId);
            if (usuario == null) {
                throw new IllegalArgumentException("Usuario no encontrado");
            }

            if (usuarioActualizado.getUsuNombres() != null) {
                usuario.setUsuNombres(usuarioActualizado.getUsuNombres());
            }
            if (usuarioActualizado.getUsuApellidos() != null) { 
                usuario.setUsuApellidos(usuarioActualizado.getUsuApellidos());
            }
            if (usuarioActualizado.getUsuNacimiento() != null) {
                usuario.setUsuNacimiento(usuarioActualizado.getUsuNacimiento());
            }
            if (usuarioActualizado.getUsuEmail() != null) {
                usuario.setUsuEmail(usuarioActualizado.getUsuEmail());
            }
            if (usuarioActualizado.getUsuEstado() != null) {
                usuario.setUsuEstado(usuarioActualizado.getUsuEstado());
            }
            if(usuarioActualizado.getUsuClave() != null){
                usuario.setUsuClave(usuarioActualizado.getUsuClave());
            }

            return em.merge(usuario);
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al actualizar usuario: " + e.getMessage());
        }
        return null;
    }

    //delete
    public void deleteUser(Long usuId) {
        try {
            Usuario usuario = em.find(Usuario.class, usuId);
            if (usuario == null) {
                throw new IllegalArgumentException("Usuario no encontrado");
            }
            em.remove(usuario);
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al eliminar usuario: " + e.getMessage());
        }
    }
}
