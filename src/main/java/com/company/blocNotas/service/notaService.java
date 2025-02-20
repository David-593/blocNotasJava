/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.blocNotas.service;

import com.mycompany.blocNotas.entities.Nota;
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
    public void CreateNota (Nota nota){
        em.persist(nota);
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
