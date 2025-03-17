
package com.mycompany.blocNotas.entities;

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
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.json.bind.annotation.JsonbDateFormat;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long usuId;
    @NotNull
    @Column(name = "usu_nombres")
    private String name;
    @NotNull
    @Column(name = "usu_apellidos")
    private String lastName;
    @NotNull
    @Column(name = "usu_nacimiento")
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate birthDay;
    @NotNull
    @Column(name = "usu_email")
    private String email;
    @Column(name= "usu_estado")
    private Boolean status;
    @Column(name = "usu_clave") //cambiar a hash value luego (ByCritp)
    private String password;

    //relacion
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL, mappedBy = "usuId")
    @JsonIgnore
    private List<NotaEntity> notaList;
    
    //constructor vacio
    public UsuarioEntity(){
        
    }
    
    //constructor con parametros
    public UsuarioEntity ( String name, String lastName,LocalDate birthDay, String email, Boolean status, String password){
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    //GETTERS AND SETTERS

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<NotaEntity> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<NotaEntity> notaList) {
        this.notaList = notaList;
    }
    

}
