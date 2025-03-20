
package com.company.blocNotas.Dao.imp;


public class UsuarioEjb {
 
  /*   @PersistenceContext
    private EntityManager em;
    
    //Usamos DAO este metodo para crear un usuario
    public void createDAO(JsonObject userJson){
        UsuarioEntity user = jsonEntity(userJson);
        em.persist(user);
    }
    
    //Metodo DAO para buscar un usuario por id y devolver  todo el usuario
    public UsuarioEntity findUserDAO(Long usuId){
        return em.find(UsuarioEntity.class, usuId);
    }
    
    //Metodo DAO para verificar si el usuario existe o no
    public boolean existUserByIdDAO(Long usuId){
        Long count = em.createQuery("SELECT COUNT(u) FROM UsuarioEntity u WHERE u.usuId = :id", Long.class)
                .setParameter("id", usuId)
                .getSingleResult();
        return count > 0;
    }
    
    //Metodo DAO para obtener todos los usuarios
    public List<UsuarioEntity> getUsersDAO(){
        return em.createQuery("SELECT c FROM Usuario c LEFT JOIN FETCH c.notaList", UsuarioEntity.class)
                .getResultList();
    }
    
    //Metodo DAO para actualizar un usuario
    public void updateDAO(Long usuId, JsonObject userJson){
        if(!existUserByIdDAO(usuId)){
            throw new EntityNotFoundException("Este usuario no ha sido encontrado para actualizar");
        }
        UsuarioEntity userUpdated = jsonEntity(userJson);
        userUpdated.setUsuId(usuId);
        em.merge(userUpdated);
    }
    
    //Metodo DAO para eliminar un usuario
    public void deleteDAO(Long usuId){
        if(!existUserByIdDAO(usuId)){
            throw new EntityNotFoundException("Este usuario no ha sido encontrado para eliminar");
        }
        UsuarioEntity userDeleted = findUserDAO(usuId);
        em.remove(userDeleted);
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
        
        //hashear la contraseña con BCrypt luego
        String password = userJson.getString("password");
        
        UsuarioEntity user = new UsuarioEntity();
        user.setName(name);
        user.setLastName(lastName);
        user.setBirthDay(formatterDate);
        user.setEmail(email);
        user.setStatus(status);
        user.setPassword(password);
        
        return user;
    }*/
}
