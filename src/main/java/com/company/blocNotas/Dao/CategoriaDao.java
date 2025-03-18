
package com.company.blocNotas.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.mycompany.blocNotas.entities.CategoriaEntity;
import jakarta.json.JsonObject;
import java.util.List;


public class CategoriaDao {
    
    @PersistenceContext
    private EntityManager em;
    
    //Usamos este metodo para crear un categoria
    public void create(JsonObject jsonCategory){
        CategoriaEntity category = jsonEntity(jsonCategory);
        em.persist(category);
    }
    
    //Usamos este metodo para buscar un usuario por id
    public CategoriaEntity findCategory(Long cateId){
        return em.find(CategoriaEntity.class, cateId);
    }
    
    //Usamos este metodo para obtener todos los usuarios
    public List<CategoriaEntity> getCategories(){
        return em.createQuery("SELECT c FROM Categoria c LEFT JOIN FETCH c.notaList", CategoriaEntity.class).getResultList();
    }
    
    public void update(Long cateId, String name, JsonObject categoryJson){
        CategoriaEntity category = findCategory(cateId);
        if(category  != null){
            CategoriaEntity categoryUpdated = jsonEntity(categoryJson);
            categoryUpdated.setName(name);
            em.merge(categoryUpdated);
        }
    }
    
    public void delete(Long usuId){
        CategoriaEntity category = findCategory(usuId);
        if(category != null){
            em.remove(category);
        }
    }
    
    private CategoriaEntity jsonEntity(JsonObject categoyJson){
        
        String category = categoyJson.getString("name");
       
        CategoriaEntity user = new CategoriaEntity();
        user.setName(category);

        return user;
    }

}
