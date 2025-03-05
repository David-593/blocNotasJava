/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.blocNotas.service;

import com.mycompany.blocNotas.entities.Categoria;
import com.mycompany.blocNotas.entities.Nota;
import com.mycompany.blocNotas.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
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
    public Nota FindByIdNota(Long notaId)throws EntityNotFoundException{
        Nota nota = em.find(Nota.class, notaId);
        if(nota == null){
            throw new EntityNotFoundException("No se ha encontrado esta nota");
        }
        return nota;
    }
    
    //Delete
    public void deleteNota(Long notaId) throws Exception{
        Nota nota = em.find(Nota.class, notaId);
        if (nota == null){
            throw new Exception("No se ha encontrado esta nota");
        }
        em.remove(nota);
    }
    //Update
    public Nota updateNota(Long notaId, Nota notaActualizada) throws Exception{
        Nota nota = em.find(Nota.class, notaId);
        if (nota == null){
            throw new Exception("No se ha encotrado esta nota");
        }
        if (notaActualizada.getNotaTitulo() != null){
            nota.setNotaTitulo(notaActualizada.getNotaTitulo());
        }
        if (notaActualizada.getNotaDescripcion() != null){
            nota.setNotaDescripcion(notaActualizada.getNotaDescripcion());
        }
        return em.merge(nota);
    }
   
}
