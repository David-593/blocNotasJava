
package com.company.blocNotas.dto;

import com.mycompany.blocNotas.entities.Usuario;
import java.time.LocalDate;


public class usuarioDto {
    private Long usuId;
    private String usuNombres;
    private String usuApellidos;
    private LocalDate usuNacimiento;
    private String usuEmail;
    private String usuClave;
    private Boolean usuEstado;
    
    //Constructor vacio
    public usuarioDto(){
        
    }

    // Constructor para convertir un Usuario en un DTO
    public usuarioDto(Usuario usuario) {
        this.usuId = usuario.getUsuId();
        this.usuNombres = usuario.getUsuNombres();
        this.usuApellidos = usuario.getUsuApellidos();
        this.usuNacimiento = usuario.getUsuNacimiento();
        this.usuEmail = usuario.getUsuEmail();
        this.usuEstado = usuario.getUsuEstado();
        this.usuClave = usuario.getUsuClave();
    }

    // Getters y Setters
    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }
    
    public LocalDate getUsuNacimiento() {
        return usuNacimiento;
    }

    public void setUsuNacimiento(LocalDate usuNacimiento) {
        this.usuNacimiento = usuNacimiento;
    }
    
    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }
    
    public String getUsuClave(){
        return usuClave;
    }
    
    public void setUsuEstado(String usuClave){
        this.usuClave = usuClave;
    }

    public Boolean getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Boolean usuEstado) {
        this.usuEstado = usuEstado;
    }
}

