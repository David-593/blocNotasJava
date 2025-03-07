
package com.company.blocNotas.dto;

import com.mycompany.blocNotas.entities.Categoria;


public class categoriaDto {
    private Long cateId;
    private String cateNombre;
    
    //Constructor vacio
    public categoriaDto(){
        
    }
    
    //Constructor con parametros 
    public categoriaDto(Categoria categoria){
        this.cateId = categoria.getCateId();
        this.cateNombre = categoria.getCateNombre();
    }
    
    //Getters and setters
    public Long getCateId(){
        return cateId;
    }
    
    public void setCateId(Long cateId){
        this.cateId = cateId;
    }
    
    public String getCateNombre(){
        return cateNombre;
    }
    
    public void setCateNombre(String cateNombre){
        this.cateNombre = cateNombre;
    }
}

