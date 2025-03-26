package com.company.blocNotas.Dao.itf;
import com.mycompany.blocNotas.entities.Usuarios;
import java.util.List;

public interface IUsuarioEjb {
    
    Usuarios createUsuario(Usuarios usuario) throws Exception;
    
    Usuarios modifyUsuario(Usuarios usuario) throws Exception;
    
    Usuarios deleteUsuario(Usuarios usuario) throws Exception;
    
    Usuarios getUsuarioById(Usuarios usuario) throws Exception;
    
    boolean existById(Integer usuId) throws Exception;
    
    List<Usuarios> getAllUsuarios() throws Exception;
}
