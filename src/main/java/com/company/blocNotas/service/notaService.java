/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.blocNotas.service;

import com.company.blocNotas.dto.NotaDto;
import com.mycompany.blocNotas.entities.Categoria;
import com.mycompany.blocNotas.entities.Nota;
import com.mycompany.blocNotas.entities.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class notaService {
    
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    
    //Create
    public void CreateNota(Nota nota) throws Exception {
       if (nota.getNotaTitulo() == null || nota.getNotaDescripcion() == null 
            || nota.getUsuId() == null || nota.getCateId() == null) {
        throw new Exception("Estos campos son obligatorios");
        }
    
        Usuario usuario = em.find(Usuario.class, nota.getUsuId());
        Categoria categoria = em.find(Categoria.class, nota.getCateId());

        if (usuario == null || categoria == null) {
            throw new Exception("Usuario o Categoria no encontrados");
        }

        nota.setUsuId(usuario);
        nota.setCateId(categoria);

        em.persist(nota);
        
       try{
            em.persist(nota); 
       }catch (Exception e){
           throw new Exception ("Ocurrio algun problema al guardar en la base de datos" + e.getMessage());
       }
        
    }
    
    //Read by id
    public NotaDto FindByIdNota(Long notaId)throws EntityNotFoundException{
        Nota nota = em.find(Nota.class, notaId);
        if(nota == null){
            throw new EntityNotFoundException("No se ha encontrado esta nota");
        }
        return new NotaDto(nota);
    }
    
    //Read all
    public List<NotaDto> findAllNota(){
        List<Nota> notas = em.createQuery(
        "SELECT n FROM Nota n JOIN FETCH n.usuId JOIN FETCH n.cateId", Nota.class)
        .getResultList();
    
    return notas.stream().map(NotaDto::new).collect(Collectors.toList());
    }
    
    //Update
    public Nota updateNota(Long notaId, Nota notaActualizada) throws EntityNotFoundException{
        Nota nota = em.find(Nota.class, notaId);
        if (nota == null){
            throw new EntityNotFoundException("No se ha encotrado esta nota");
        }
        if (notaActualizada.getNotaTitulo() != null){
            nota.setNotaTitulo(notaActualizada.getNotaTitulo());
        }
        if (notaActualizada.getNotaDescripcion() != null){
            nota.setNotaDescripcion(notaActualizada.getNotaDescripcion());
        }
        return em.merge(nota);
    }
   
    //Delete
    public void deleteNota(Long notaId) throws EntityNotFoundException{
        Nota nota = em.find(Nota.class, notaId);
        if (nota == null){
            throw new EntityNotFoundException("No se ha encontrado esta nota");
        }
        em.remove(nota);
    }
}
