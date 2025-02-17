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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "categoria")
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByCateId", query = "SELECT c FROM Categoria c WHERE c.cateId = :cateId"),
    @NamedQuery(name = "Categoria.findByCateNombre", query = "SELECT c FROM Categoria c WHERE c.cateNombre = :cateNombre")})
public class Categoria implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "cate_nombre")
    private String cateNombre;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cate_id")
    private Integer cateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cateId")
    private Collection<Nota> notaCollection;

    public Categoria() {
    }

    public Categoria(Integer cateId) {
        this.cateId = cateId;
    }

    public Categoria(Integer cateId, String cateNombre) {
        this.cateId = cateId;
        this.cateNombre = cateNombre;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateNombre() {
        return cateNombre;
    }

    public void setCateNombre(String cateNombre) {
        this.cateNombre = cateNombre;
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
        hash += (cateId != null ? cateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.cateId == null && other.cateId != null) || (this.cateId != null && !this.cateId.equals(other.cateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.blocNotas.entities.Categoria[ cateId=" + cateId + " ]";
    }
}






/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package com.mycompany.blocNotas.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author andre
 */
/*
public class categoriaEntity {
    
    @Entity 
    @Table(name = "categoria")
    public class Categoria {
        
        @Id
        @GeneratedValue(strategy  = GenerationType.IDENTITY)
        private Long cate_id;
        
        @Column(nullable = false)
        private String cate_nombre;
        
        @OneToMany(mappedBy = "categoria")
        public List<notaEntity> Notas ;
        
        //constructor vacio
        public Categoria (){
            
        }
        
        //getters y setters
        public Long getCate_id(){
            return cate_id;
        }
        public void setCate_id(Long cate_id){
            this.cate_id = cate_id;
        }
        
        public String getCate_nombre(){
            return cate_nombre;
        }
        public void setCate_nombre(String cate_nombre){
            this.cate_nombre = cate_nombre;
        }
        
        public List<notaEntity> getNotas() {
            return Notas;
        }

        public void setNotas(List <notaEntity> Notas) {
            this.Notas = Notas;
        }
    }
    
}
*/
