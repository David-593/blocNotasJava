package com.company.blocNotas.Dao.imp;

import com.company.blocNotas.Dao.itf.ICategoriaEjb;
import com.mycompany.blocNotas.entities.Categoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless(name = "EJB_CATEGORIA")
public class CategoriaEjb implements ICategoriaEjb {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    @Override
    public Categoria createCategoria(Categoria categoria) throws Exception {
        em.persist(categoria);
        return categoria;
    }

    @Override
    public void modifyCategoria(Categoria categoria) throws Exception {
        if(!existById(categoria.getCateId())){
            throw new EntityNotFoundException("Entidad con ese id, no existe para actualizar");
        }
        em.merge(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) throws Exception {
        if(!existById(categoria.getCateId())){
            throw new EntityNotFoundException("Entidad con ese id, no existe para eliminar");
        }
        em.remove(categoria);
    }

    @Override
    public Categoria getCategoriaById(Categoria categoria) throws Exception {
        if(!existById(categoria.getCateId())){
            throw new EntityNotFoundException("Ninguna categoria esta asociada con ese id");
        }
        Categoria category = em.find(Categoria.class, categoria.getCateId());
        return category;
    }

    @Override
    public List<Categoria> getAllCategorias() throws Exception {
        return em.createQuery("SELECT c FROM Categoria c LEFT JOIN FETCH c.notaList", Categoria.class)
                .getResultList();
    }

    @Override
    public boolean existById(Integer cateId) throws Exception {
        return em.find(Categoria.class, cateId) != null;
    }


//////    //Metodo DAO para crear un categoria
//////    public void createCategoryDAO(JsonObject categoryJson){
//////        CategoriaEntity category = jsonEntity(categoryJson);
//////        em.persist(category);
//////    }
//////    
//////    //Metodo DAO para buscar una categoria por id y devolver todo la categoria
//////    public CategoriaEntity findCategoryDAO(Long cateId){
//////        return em.find(CategoriaEntity.class, cateId);
//////    }
//////    
//////    //Metodo DAO para encontrar solo el id 
//////    public boolean existCategoryByIdDAO(Long cateId){
//////        Long count = em.createQuery("SELECT COUNT(c) FROM CategoryEntity u WHERE u.cateId = :id ", Long.class)
//////                .setParameter("id", cateId)
//////                .getSingleResult();
//////        return count > 0;
//////    }
//////    
//////    //Metodo DAO para obtener todas las categorias
//////    public List<CategoriaEntity> getCategoriesDAO(){
//////        return em.createQuery("SELECT c FROM Categoria c LEFT JOIN FETCH c.notaList", CategoriaEntity.class).getResultList();
//////    }
//////    
//////    //Metodo DAO para actualizar una categoria
//////    public void updateDAO(Long cateId, JsonObject categoryJson){
//////       if(!existCategoryByIdDAO(cateId)){
//////           throw new EntityNotFoundException("Categoria no encontrado para eliminar");
//////       }
//////        CategoriaEntity categoryUpdated = findCategoryDAO(cateId);
//////        categoryUpdated.setCateId(cateId);
//////        em.merge(categoryUpdated);
//////    }
//////    
//////    //Metodo DAO para eliminar una categoria
//////    public void deleteDAO(Long cateId){
//////      if(!existCategoryByIdDAO(cateId)){
//////          throw new EntityNotFoundException("Categoria no existe para eliminar");
//////      }
//////      CategoriaEntity categoryDeleted = findCategoryDAO(cateId);
//////      em.remove(categoryDeleted);
//////    }
//////    
//////    private CategoriaEntity jsonEntity(JsonObject categoryJson){
//////        
//////        String category = categoryJson.getString("name");
//////       
//////        CategoriaEntity user = new CategoriaEntity();
//////        user.setName(category);
//////
//////        return user;
//////    }

}
