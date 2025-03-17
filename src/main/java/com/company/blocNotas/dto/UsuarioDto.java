
package com.company.blocNotas.dto;

import com.mycompany.blocNotas.entities.UsuarioEntity;
import java.time.LocalDate;


public class UsuarioDto {
    private Long usuId;
    private String name;
    private String lastName;
    private LocalDate birthDay;
    private String email;
    private String password;
    private Boolean status;
    
    //GETTERS Y SETTERS
    public UsuarioDto(){
        
    }

    // Constructor para convertir un Usuario en un DTO
    public UsuarioDto(UsuarioEntity usuario) {
        this.usuId = usuario.getUsuId();
        this.name = usuario.getName();
        this.lastName = usuario.getLastName();
        this.birthDay = usuario.getBirthDay();
        this.email = usuario.getEmail();
        this.status = usuario.getStatus();
        this.password = usuario.getPassword();
    }

    //Getters y Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
}

