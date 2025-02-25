/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.blocNotas.service;

import com.mycompany.blocNotas.entities.Categoria;
import com.mycompany.blocNotas.entities.Nota;
import com.mycompany.blocNotas.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
public class notaService {
    
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    
    //Create
    public void CreateNota(Nota nota) throws Exception {
       if (nota.getNotaTitulo() == null || nota.getNotaDescripcion() == null 
            || nota.getUsuId() == null || nota.getCateId() == null){
           throw new Exception("Estos campos son obligatorios");
       }
       Categoria categoria = em.find(Categoria.class, nota.getCateId());
        if (categoria == null){
            throw new Exception("Categoria no encontrada");
        }
        Usuario usuario = em.find(Usuario.class, nota.getUsuId());
        if (usuario == null){
            throw new Exception("Usuario no encontrado");
        }
        
       try{
            em.persist(nota); 
       }catch (Exception e){
           throw new Exception ("Ocurrio algun problema al guardar en la base de datos" + e.getMessage());
       }
        
    }
    
    //Read by id
    public Nota FindByIdNota(Long notaId){
        return em.find(Nota.class, notaId);
    }
    
    //Delete
    public void deleteNota(Nota nota){
        em.remove(nota);
    }
    //Update
    public Nota updateNota(Nota nota){
        return em.merge(nota);
    }
   
}
