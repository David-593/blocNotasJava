package com.company.blocNotas.Dao.itf;

import com.mycompany.blocNotas.entities.Categoria;

/**
 * Creanos una interfaz para mantener el codigo en otro lado
 * @author andre
 */
public interface ICategoriaEjb {
    
    Categoria createCategoria(Categoria categoria) throws Exception;
    
    Categoria modifyCategoria(Categoria categoria) throws Exception;
    
    Categoria deleteCategoria(Categoria categoria) throws Exception;
    
    Categoria getCategoria (Categoria categoria) throws Exception;
}
