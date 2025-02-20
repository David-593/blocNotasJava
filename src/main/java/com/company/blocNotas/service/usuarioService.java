/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.blocNotas.service;


import com.mycompany.blocNotas.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
public class usuarioService {
    
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    
    //create
    public void createUser(Usuario usuario){
        em.persist(usuario);
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
