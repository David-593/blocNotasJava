/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blocNotas.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long usuId;
    @NotNull
    @Column(name = "usu_nombres")
    private String usuNombres;
    @NotNull
    @Column(name = "usu_apellidos")
    private String usuApellidos;
    @NotNull
    @Column(name = "usu_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date usuNacimiento;
    @NotNull
    @Column(name = "usu_email")
    private String usuEmail;
    @Column(name= "usu_estado")
    private Boolean usuEstado;
    @Column(name = "usu_clave") //cambiar a hash value luego (ByCritp)
    private String usuClave;

    //relacion
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private Collection<Nota> notaCollection;
    
    public Usuario(){
        
    }
    
    //constructor con parametros
    public Usuario (String usuNombres, String usuApellidos,Date usuNacimiento, String usuEmail, Boolean usuEstado , String usuClave ){
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.usuNacimiento = usuNacimiento;
        this.usuEmail = usuEmail;
        this.usuEstado = usuEstado;
        this.usuClave = usuClave;
    }

    //GETTERS AND SETTERS
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

    public Date getUsuNacimiento() {
        return usuNacimiento;
    }

    public void setUsuNacimiento(Date usuNacimiento) {
        this.usuNacimiento = usuNacimiento;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public Boolean getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(Boolean usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Collection<Nota> getNotaCollection() {
        return notaCollection;
    }

    public void setNotaCollection(Collection<Nota> notaCollection) {
        this.notaCollection = notaCollection;
    }

}
