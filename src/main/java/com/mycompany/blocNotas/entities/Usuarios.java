/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blocNotas.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuId", query = "SELECT u FROM Usuarios u WHERE u.usuId = :usuId"),
    @NamedQuery(name = "Usuarios.findByUsuNombres", query = "SELECT u FROM Usuarios u WHERE u.usuNombres = :usuNombres"),
    @NamedQuery(name = "Usuarios.findByUsuApellidos", query = "SELECT u FROM Usuarios u WHERE u.usuApellidos = :usuApellidos"),
    @NamedQuery(name = "Usuarios.findByUsuNacimiento", query = "SELECT u FROM Usuarios u WHERE u.usuNacimiento = :usuNacimiento"),
    @NamedQuery(name = "Usuarios.findByUsuEmail", query = "SELECT u FROM Usuarios u WHERE u.usuEmail = :usuEmail"),
    @NamedQuery(name = "Usuarios.findByUsuEstado", query = "SELECT u FROM Usuarios u WHERE u.usuEstado = :usuEstado"),
    @NamedQuery(name = "Usuarios.findByUsuClave", query = "SELECT u FROM Usuarios u WHERE u.usuClave = :usuClave")})
public class Usuarios implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "usu_nombres")
    private String usuNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "usu_apellidos")
    private String usuApellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date usuNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "usu_email")
    private String usuEmail;
    @Size(max = 48)
    @Column(name = "usu_clave")
    private String usuClave;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id")
    private Integer usuId;
    @Column(name = "usu_estado")
    private Boolean usuEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private Collection<Nota> notaCollection;

    public Usuarios() {
    }

    public Usuarios(Integer usuId) {
        this.usuId = usuId;
    }

    public Usuarios(Integer usuId, String usuNombres, String usuApellidos, Date usuNacimiento, String usuEmail) {
        this.usuId = usuId;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.usuNacimiento = usuNacimiento;
        this.usuEmail = usuEmail;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.blocNotas.entities.Usuarios[ usuId=" + usuId + " ]";
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package com.mycompany.blocNotas.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author andre
 */
/*
public class usuarioEntity {
    
    @Entity
    @Table(name = "usuarios")
    public static class Usuario{
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long usu_id;
        
        @Column(nullable = false)
        public String usu_nombres;
        
        @Column(nullable = false)
        public String usu_apellidos;
        
        @Column(nullable = false)
        public LocalDate usu_nacimiento;
        
        @Column(nullable = false, unique = true)
        public String usu_email;
        
        @Column(nullable = false)
        public String usu_clave;
        
        @Column(nullable = false)
        public Boolean usu_estado = true;
        
        @OneToMany(mappedBy = "usuario")
        public List<notaEntity> Notas;
        
        
        //Constructor vacio
        public Usuario (){}
        
        //Getters y Setters 
        public Long getUsu_id (){
            return usu_id;
        }
        public void setUsu_id(Long usu_id){
            this.usu_id = usu_id;
        }
        
        public  String getUsu_nombres(){
            return usu_nombres;
        }
        public void setUsu_nombres(String usu_nombres){
            this.usu_nombres = usu_nombres;
        }
        
        public String getUsu_apellidos(){
            return usu_apellidos;
        }
        public void setUsu_apellidos(String usu_apellidos){
            this.usu_apellidos = usu_apellidos;
        }
        
        public LocalDate getUsu_nacimiento(){
            return usu_nacimiento;
        }
        public void setUsu_nacimiento(LocalDate usu_nacimiento){
            this.usu_nacimiento = usu_nacimiento;
        }
        
        public String getUsu_email(){
            return usu_email;
        }
        public void setUsu_email(String usu_email){
            this.usu_email = usu_email;
        }
        
        public Boolean getUsu_estado(){
            return usu_estado;
        } 
        public void setUsu_estado(Boolean usu_estado){
            this.usu_estado = usu_estado;
        }
        
        public String getUsu_clave(){
            return usu_clave;
        }
        public void setUsu_clave(String usu_clave){
             this.usu_clave = usu_clave;
        }
        
        public List<notaEntity> getNotas() {
            return Notas;
        }

        public void setNotas(List<notaEntity> Notas) {
            this.Notas = Notas;
        }
        
        
    }
}
*/