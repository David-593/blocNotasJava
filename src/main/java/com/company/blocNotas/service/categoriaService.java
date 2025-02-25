/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.blocNotas.service;

import com.mycompany.blocNotas.entities.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
public class categoriaService {
    
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    
    //Create
    public void createCategoria (Categoria categoria) throws Exception{
        if (categoria.getCateNombre()== null){
            throw new Exception("Este campo debe ser obligatorio");
        }
        try {
            em.persist(categoria); 
        } catch (Exception e) {
            throw new Exception("Ocurrió un error al guardar en la base de datos"+ e.getMessage());
        }
       
    }
    //Read by id
    public Categoria getCategoriaById(Long cateId){
        return em.find(Categoria.class, cateId);
    }
    
    //Update
    public Categoria updateCategoria(Categoria categoria){
        return em.merge(categoria);
    }
    
    //Delete
    public void deleteCategoria(Categoria categoria){
        em.remove(categoria);
    }
}
