
package com.mycompany.blocNotas.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "nota")
public class NotaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nota_id")
    private Long notaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "nota_titulo")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nota_descripcion")
    private String description;

    //relaciones con categoria y usuario
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")
    @ManyToOne(optional = false)
    private CategoriaEntity cateId;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private UsuarioEntity usuId;
    
    //constructor sin parametros
   public NotaEntity(){
       
   }

   //Constructor con parametros
   public void Nota ( String title,String description, CategoriaEntity cateId, UsuarioEntity usuId){
    this.title = title;
    this.description = description;
    this.cateId = cateId;
    this.usuId = usuId;
   }
   
   //GETTERS AND SETTERS
    public Long getNotaId() {
        return notaId;
    }

    public void setNotaId(Long notaId) {
        this.notaId = notaId;
    }

    public String getNotaTitulo() {
        return title;
    }

    public void setNotaTitulo(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return description;
    }

    public void setDescripcion(String description) {
        this.description = description;
    }

    public CategoriaEntity getCateId() {
        return cateId;
    }

    public void setCateId(CategoriaEntity cateId) {
        this.cateId = cateId;
    }

    public UsuarioEntity getUsuId() {
        return usuId;
    }

    public void setUsuId(UsuarioEntity usuId) {
        this.usuId = usuId;
    }
   
   
}
