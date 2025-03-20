package com.company.blocNotas.service.imp;

import com.company.blocNotas.Dao.itf.ICategoriaEjb;
import com.mycompany.blocNotas.entities.Categoria;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.json.JsonObject;
import com.company.blocNotas.service.itf.ICategoriaService;
import jakarta.ejb.EJB;

@RequestScoped
@Named(value = "CategoriaService")
public class CategoriaService implements ICategoriaService {

    @EJB
    private ICategoriaEjb categoriaEjb;

    /**
     * Aqui va la logica del crear categorie aqui se tranfosrma el JsonObject a
     * Categoria de la base de datos
     *
     * @param categoriaJson
     * @return
     * @throws Exception
     */
    @Override
    public Categoria createCategoria(JsonObject categoriaJson) throws Exception {
        Categoria categoria = new Categoria();
        categoria.setCateNombre(categoriaJson.getString("nombre"));
        return categoriaEjb.createCategoria(categoria);
    }

    @Override
    public Categoria modifyCategoria(JsonObject usuarioJson) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Categoria updateCategoria(JsonObject categoriaJson) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Categoria deleteCategoria(JsonObject categoriaJson) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /* @PersistenceContext(name = "pruebaPU")
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
    }*/

}
