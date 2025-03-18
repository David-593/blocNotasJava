
package com.company.blocNotas.Dao;

import com.mycompany.blocNotas.entities.UsuarioEntity;
import jakarta.json.JsonObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class UsuarioDao {
 
     @PersistenceContext
    private EntityManager em;
    
    //Usamos este metodo para crear un usuario
    public void create(JsonObject jsonEntity){
        UsuarioEntity user = jsonEntity(jsonEntity);
        em.persist(user);
    }
    
    //Usamos este metodo para buscar un usuario por id
    public UsuarioEntity findUser(Long usuId){
        return em.find(UsuarioEntity.class, usuId);
    }
    
    //Usamos este metodo para obtener todos los usuarios
    public List<UsuarioEntity> getUsers(){
        return em.createQuery("SELECT c FROM Usuario c LEFT JOIN FETCH c.notaList", UsuarioEntity.class).getResultList();
    }
    
    public void update(Long usuId, JsonObject userJson){
        UsuarioEntity usuarioDto = findUser(usuId);
        if(usuarioDto  != null){
            UsuarioEntity userUpdated = jsonEntity(userJson);
            userUpdated.setUsuId(usuId);
            em.merge(userUpdated);
        }
    }
    
    public void delete(Long usuId){
        UsuarioEntity usuarioDto = findUser(usuId);
        if(usuarioDto != null){
            em.remove(usuarioDto);
        }
    }
    
    private UsuarioEntity jsonEntity(JsonObject userJson){
        String name = userJson.getString("name");
        String lastName = userJson.getString("lastName");
        
        //Pasar nacimiento a ObjetoJson transforandolo a String
        String dateStr = userJson.getString("birthDay");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatterDate = LocalDate.parse(dateStr, formatter);
        
        String email = userJson.getString("email");
        Boolean status = userJson.getBoolean("status");
        
        //hashear la contraseña con BCrypt
        String password = userJson.getString("password");
        
        UsuarioEntity user = new UsuarioEntity();
        user.setName(name);
        user.setLastName(lastName);
        user.setBirthDay(formatterDate);
        user.setEmail(email);
        user.setStatus(status);
        user.setPassword(password);
        
        return user;
    }
}
