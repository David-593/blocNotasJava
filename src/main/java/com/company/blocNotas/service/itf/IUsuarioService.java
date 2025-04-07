package com.company.blocNotas.service.itf;

import com.mycompany.blocNotas.entities.Usuarios;
import jakarta.json.JsonObject;
import java.util.List;

public interface IUsuarioService {
    Usuarios createUsuario(JsonObject usuarioJson) throws Exception;
    
    Usuarios modifyUsuario(JsonObject usuarioJson) throws Exception;
    
    Usuarios deleteUsuario(JsonObject usuarioJson) throws Exception;
    
    Usuarios getUsuarioByid(JsonObject usuarioJson) throws Exception;
    
    boolean existyById(JsonObject usuarioJson) throws Exception;
    
    List<Usuarios> getAllUsuarios(JsonObject usuarioJson) throws Exception;
}
