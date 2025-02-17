/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blocNotas.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "nota")
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n"),
    @NamedQuery(name = "Nota.findByNotaId", query = "SELECT n FROM Nota n WHERE n.notaId = :notaId"),
    @NamedQuery(name = "Nota.findByNotaTitulo", query = "SELECT n FROM Nota n WHERE n.notaTitulo = :notaTitulo"),
    @NamedQuery(name = "Nota.findByNotaDescripcion", query = "SELECT n FROM Nota n WHERE n.notaDescripcion = :notaDescripcion")})
public class Nota implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "nota_titulo")
    private String notaTitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nota_descripcion")
    private String notaDescripcion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nota_id")
    private Integer notaId;
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")
    @ManyToOne(optional = false)
    private Categoria cateId;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuarios usuId;

    public Nota() {
    }

    public Nota(Integer notaId) {
        this.notaId = notaId;
    }

    public Nota(Integer notaId, String notaTitulo, String notaDescripcion) {
        this.notaId = notaId;
        this.notaTitulo = notaTitulo;
        this.notaDescripcion = notaDescripcion;
    }

    public Integer getNotaId() {
        return notaId;
    }

    public void setNotaId(Integer notaId) {
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

    public Categoria getCateId() {
        return cateId;
    }

    public void setCateId(Categoria cateId) {
        this.cateId = cateId;
    }

    public Usuarios getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuarios usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notaId != null ? notaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.notaId == null && other.notaId != null) || (this.notaId != null && !this.notaId.equals(other.notaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.blocNotas.entities.Nota[ notaId=" + notaId + " ]";
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package com.mycompany.blocNotas.entities;

import com.mycompany.blocNotas.entities.categoriaEntity.Categoria;
import com.mycompany.blocNotas.entities.usuarioEntity.Usuario;
import jakarta.persistence.*;

/**
 *
 * @author andre
 */
/*
public class notaEntity {
    
    @Entity
    @Table(name = "nota")
    public class Nota {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long nota_id;
        
        @Column(nullable = false)
        private String nota_titulo;
        
        @Column(nullable = false)
        private String nota_descripcion;
        
        @ManyToOne 
        @JoinColumn (name = "usu_id", referencedColumnName = "usu_id")
        private usuarioEntity.Usuario usuario;
        
        @ManyToOne 
        @JoinColumn(name = "")
        private categoriaEntity.Categoria categoria;
        
        //contructor vacio 
        public Nota (){
            
        }
        
        public Long getNota_id(){
            return nota_id;
        }
        public void setNota_id(Long nota_id){
            this.nota_id = nota_id;
        }
        
        public String getNota_titulo(){
            return nota_titulo;
        }
        public void setNota_titulo(String nota_titulo){
            this.nota_titulo = nota_titulo;
        }
        
        public String getNota_descripcion(){
            return nota_descripcion;
        }
        public void setNota_descripcion(String nota_descripcion){
            this.nota_descripcion = nota_descripcion;
        }
        
        public usuarioEntity.Usuario getUsuario_id(){
            return usuario;
        }
        public void setUsuario_id(Usuario usuario){
            this.usuario.usu_id = usuario.usu_id;
        }
        
        public categoriaEntity.Categoria getCategoria_id(){
            return categoria;
        }
        public void setCategoria_id(Categoria categoria){
        }
        
    }
}
*/