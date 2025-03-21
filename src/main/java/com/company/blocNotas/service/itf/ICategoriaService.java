package com.company.blocNotas.service.itf;

import com.mycompany.blocNotas.entities.Categoria;
import jakarta.json.JsonObject;
import java.util.List;

/**
 *
 * @author andre
 */
public interface ICategoriaService {
    
    Categoria createCategoria(JsonObject categoriaJson) throws Exception;
    
    Categoria modifyCategoria(JsonObject categoriaJson) throws Exception;
    
    Categoria updateCategoria(JsonObject categoriaJson) throws Exception;
    
    Categoria deleteCategoria(JsonObject categoriaJson) throws Exception;
    
    List<Categoria> gettAllCategoria(JsonObject categoriaJson) throws Exception;
    
}
