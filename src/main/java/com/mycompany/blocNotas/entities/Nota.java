package com.mycompany.blocNotas.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n")})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nota_id")
    private Integer notaId;
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
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios usuarios;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
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
        return "com.mycompany.blocNotas.entities2.Nota[ notaId=" + notaId + " ]";
    }
    
}
