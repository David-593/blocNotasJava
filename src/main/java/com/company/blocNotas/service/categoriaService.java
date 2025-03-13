
package com.company.blocNotas.service;

import com.company.blocNotas.dto.categoriaDto;
import com.mycompany.blocNotas.entities.Categoria;
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
    public categoriaDto getCategoriaById(Long cateId) throws Exception{
         Categoria categoria = em.find(Categoria.class, cateId);
         if (categoria == null){
             throw new Exception("No se ha encontrado esta categoria");
         }
         return new categoriaDto(categoria);
    }
    
    //Read all categories
    public List<Categoria> getAllCategorie(){
        return em.createQuery("SELECT c FROM Categoria c LEFT JOIN FETCH c.notaList", Categoria.class).getResultList();
    }
    
    //Update
    public Categoria updateCategoria(Long cateId, String cateNombre)throws EntityNotFoundException{
        Categoria categoria = em.find(Categoria.class, cateId);
        if(categoria == null){
            throw new EntityNotFoundException("No se ha encontrado esta categoria" + cateId);
        }
        if(cateNombre == null || cateNombre.trim().isEmpty()){
            throw new IllegalArgumentException("Este nombre no puede ser vacio o nulo");
        }
        categoria.setCateNombre(cateNombre);
        return em.merge(categoria);
    }
    
    //Delete
    public void deleteCategoria(Long cateId)throws EntityNotFoundException{
        Categoria categoria = em.find(Categoria.class, cateId);
        if (categoria == null){
            throw new EntityNotFoundException("No se ha encontrado esta categoria");
        }
        em.remove(categoria);
    }
}
