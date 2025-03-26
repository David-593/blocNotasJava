package com.company.blocNotas.Dao.itf;

import com.mycompany.blocNotas.entities.Categoria;
import java.util.List;

/**
 * Creamos una interfaz para mantener el codigo en otro lado
 * @author andre
 */
public interface ICategoriaEjb {
    
    Categoria createCategoria(Categoria categoria) throws Exception;
    
    Categoria modifyCategoria(Categoria categoria) throws Exception;
    
    Categoria deleteCategoria(Categoria categoria) throws Exception;
    
    Categoria getCategoriaById (Categoria categoria) throws Exception;
    
    boolean existById(Integer cateId) throws Exception;
    
    List<Categoria> getAllCategorias() throws Exception;
}
