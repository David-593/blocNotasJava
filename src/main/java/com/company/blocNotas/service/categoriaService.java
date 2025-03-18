
package com.company.blocNotas.service;

import com.company.blocNotas.dto.CategoriaDto;
import com.mycompany.blocNotas.entities.CategoriaEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class categoriaService {
    
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    
    //Create
    public void createCategoria (CategoriaEntity categoria) throws Exception{
        if (categoria.getName()== null){
            throw new Exception("Este campo debe ser obligatorio");
        }
        try {
            em.persist(categoria); 
        } catch (Exception e) {
            throw new Exception("Ocurrió un error al guardar en la base de datos"+ e.getMessage());
        }
       
    }
    //Read by id
    public CategoriaDto getCategoriaById(Long cateId) throws Exception{
         CategoriaEntity categoria = em.find(CategoriaEntity.class, cateId);
         if (categoria == null){
             throw new Exception("No se ha encontrado esta categoria");
         }
         return new CategoriaDto(categoria);
    }
    
    //Read all categories
    public List<CategoriaEntity> getAllCategorie(){
        return em.createQuery("SELECT c FROM Categoria c LEFT JOIN FETCH c.notaList", CategoriaEntity.class).getResultList();
    }
    
    //Update
    public CategoriaEntity updateCategoria(Long cateId, String cateNombre)throws EntityNotFoundException{
        CategoriaEntity categoria = em.find(CategoriaEntity.class, cateId);
        if(categoria == null){
            throw new EntityNotFoundException("No se ha encontrado esta categoria" + cateId);
        }
        if(cateNombre == null || cateNombre.trim().isEmpty()){
            throw new IllegalArgumentException("Este nombre no puede ser vacio o nulo");
        }
        categoria.setName(cateNombre);
        return em.merge(categoria);
    }
    
    //Delete
    public void deleteCategoria(Long cateId)throws EntityNotFoundException{
        CategoriaEntity categoria = em.find(CategoriaEntity.class, cateId);
        if (categoria == null){
            throw new EntityNotFoundException("No se ha encontrado esta categoria");
        }
        em.remove(categoria);
    }
}
