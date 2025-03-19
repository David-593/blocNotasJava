
package com.company.blocNotas.dto;

import com.mycompany.blocNotas.entities.NotaEntity;

public class NotaDto {
    
    private Long notaId;
    private String notaTitulo;
    private String notaDescripcion;
    private Long usuId;
    private Long cateId;
    
    //Constructor vacio
    public NotaDto(){
        
    }
    
    //constructor para convertir NotaEntity en un dto
    public NotaDto(NotaEntity nota){
        this.notaId = nota.getNotaId();
        this.notaTitulo = nota.getNotaTitulo();
        this.notaDescripcion = nota.getDescripcion();
        this.cateId = nota.getCateId().getCateId();
        this.usuId = nota.getUsuId().getUsuId();
    }

    //Getters y setters
    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public Long getNotaId() {
        return notaId;
    }

    public void setNotaId(Long notaId) {
        this.notaId = notaId;
    }

    public String getNotaTitulo() {
        return notaTitulo;
    }

    public void setNotaTitulo(String notaTitulo) {
        this.notaTitulo = notaTitulo;
    }

    public String getNotaDescripcion() {
        return notaDescripcion;
    }

    public void setNotaDescripcion(String notaDescripcion) {
        this.notaDescripcion = notaDescripcion;
    }
}

