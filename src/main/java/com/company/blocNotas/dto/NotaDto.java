
package com.company.blocNotas.dto;

import com.mycompany.blocNotas.entities.Nota;

public class NotaDto {
    private Long notaId;
    private String notaTitulo;
    private String notaDescripcion;
    private Long usuId;
    private Long cateId;
    
    
    public NotaDto(){
        
    }
    
    public NotaDto(Nota nota){
        this.notaId = nota.getNotaId();
        this.notaTitulo = nota.getNotaTitulo();
        this.notaDescripcion = nota.getNotaDescripcion();
        this.cateId = nota.getCateId().getCateId();
        this.usuId = nota.getUsuId().getUsuId();
    }

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

