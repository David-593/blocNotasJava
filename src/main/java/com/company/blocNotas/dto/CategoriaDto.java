
package com.company.blocNotas.dto;


import com.mycompany.blocNotas.entities.CategoriaEntity;


public class CategoriaDto {
    private Long cateId;
    private String cateNombre;
    
    //Constructor vacio
    public CategoriaDto(){
        
    }
    
    //Constructor con parametros 
    public CategoriaDto(CategoriaEntity categoria){
        this.cateId = categoria.getCateId();
        this.cateNombre = categoria.getName();
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


