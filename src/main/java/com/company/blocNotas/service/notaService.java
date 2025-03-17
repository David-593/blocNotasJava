
package com.company.blocNotas.service;

import com.company.blocNotas.dto.NotaDto;
import com.mycompany.blocNotas.entities.CategoriaEntity;
import com.mycompany.blocNotas.entities.NotaEntity;
import com.mycompany.blocNotas.entities.UsuarioEntity;
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
    public void CreateNota(NotaDto nota) throws Exception {
       if (nota.getNotaTitulo() == null || nota.getNotaDescripcion() == null 
            || nota.getUsuId() == null || nota.getCateId() == null) {
        throw new Exception("Estos campos son obligatorios");
        }
    
        UsuarioEntity usuario = em.find(UsuarioEntity.class, nota.getUsuId());
        CategoriaEntity categoria = em.find(CategoriaEntity.class, nota.getCateId());

        if (usuario == null || categoria == null) {
            throw new Exception("Usuario o Categoria no encontrados");
        }
        em.persist(nota);
        
       try{
            em.persist(nota); 
       }catch (Exception e){
           throw new Exception ("Ocurrio algun problema al guardar en la base de datos" + e.getMessage());
       }
        
    }
    
    //Read by id
    public NotaDto FindByIdNota(Long notaId)throws EntityNotFoundException{
        NotaEntity nota = em.find(NotaEntity.class, notaId);
        if(nota == null){
            throw new EntityNotFoundException("No se ha encontrado esta nota");
        }
        return new NotaDto(nota);
    }
    
    //Read all
    public List<NotaDto> findAllNota(){
        List<NotaEntity> notas = em.createQuery(
        "SELECT n FROM Nota n JOIN FETCH n.usuId JOIN FETCH n.cateId", NotaEntity.class)
        .getResultList();
    
    return notas.stream().map(NotaDto::new).collect(Collectors.toList());
    }
    
    //Update
    public NotaEntity updateNota(Long notaId, NotaEntity notaActualizada) throws EntityNotFoundException{
        NotaEntity nota = em.find(NotaEntity.class, notaId);
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
        NotaEntity nota = em.find(NotaEntity.class, notaId);
        if (nota == null){
            throw new EntityNotFoundException("No se ha encontrado esta nota");
        }
        em.remove(nota);
    }
}
