
package com.company.blocNotas.Dao;

import com.mycompany.blocNotas.entities.NotaEntity;
import jakarta.json.JsonObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import java.util.List;


public class NotaDao {
    
    @PersistenceContext(name = "pruebaPU")
    private EntityManager em;
    
    //Metodo DAO para crear una nota
    public void create (JsonObject notaJson){
        NotaEntity note = JsonEntity(notaJson);
        em.persist(note);
    }
    
    //Metodo DAO para buscar una nota por id y devolver toda la nota
    public NotaEntity findNoteDAO(Long notaId){
        return em.find(NotaEntity.class, notaId);
    }
    
     //Metodo DAO para enontrar solo el id
    public boolean existNoteByIdDAO(Long notaId){
        Long count = em.createQuery("SELECT COUNT(n) FROM NotaEntity u WHERE n.notaId = : id", Long.class)
                .setParameter("id", notaId)
                .getSingleResult();
        return count > 0;
    }
    
    //Metodo DAO para obtener todas las notas
    public List<NotaEntity> getNotesDAO(){
        return em.createQuery("SELECT c FROM Nota c LEFT JOIN FETCH c.notaList", NotaEntity.class).getResultList();
    }
    
    //Metodo DAO para actualizar
    public void updateNoteDAO(Long notaId, JsonObject notaJson){
        if(!existNoteByIdDAO(notaId)){
            throw new EntityNotFoundException("Nota no encontrada para actualizar");
        }
        NotaEntity noteUpdated = findNoteDAO(notaId);
        noteUpdated.setNotaId(notaId);
        em.merge(noteUpdated);
    }
    
    //Metodo DAO para eliminar
    public void deleteNoteDAO(Long notaId, JsonObject notaJson){
        if(!existNoteByIdDAO(notaId)){
            throw new EntityNotFoundException("Nota no existe para eliminar");
        }
        NotaEntity noteDeleted = findNoteDAO(notaId);
        em.remove(noteDeleted);
    }
   
    
    private NotaEntity JsonEntity(JsonObject noteJson){
        String title = noteJson.getString("title");
        String description = noteJson.getString("description");
        
        NotaEntity note = new NotaEntity();
        note.setNotaTitulo(title);
        note.setDescripcion(description);
        
        return note;
    }
    
    
}
