
package com.mycompany.blocNotas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria")
public class CategoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private Long cateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "cate_nombre")
    private String name;

    //relacion 
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL, mappedBy = "cateId")
    @JsonIgnore
    private List<NotaEntity> notaList;

    public CategoriaEntity(){
        
    }
    
    //Constructor con parametros 
    public CategoriaEntity (Long cateId, String name){
        this.name = name;
    }
    
    //GETTERS AND SETTERS

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NotaEntity> getNotaList() {
        return notaList;
    }

    public void setNotaCollection(List<NotaEntity> notaList) {
        this.notaList = notaList;
    }
    
}
