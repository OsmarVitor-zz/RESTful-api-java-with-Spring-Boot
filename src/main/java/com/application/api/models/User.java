package com.application.api.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.application.api.dto.UserDTO;
import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "birth_date")
    @NotNull
    private String birthDate;

    @Column(name = "identifier", unique = true)
    @NotNull
    public String identifier;

    @Column(columnDefinition = "BOOLEAN DEFAULT false", name = "admin")
    public boolean admin;
    
    public User() {
    }
    
    public User(String name, String birthDate, String identifier) {
        this.name = name;
        this.birthDate = birthDate;
        this.identifier = identifier;
    }
    
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Users [uuid=" + uuid + ", name=" + name + ", age=" + birthDate + "]";
    }

    public static UserDTO valueOf(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setBirthDate(entity.getBirthDate());
        userDTO.setIdentifier(entity.getIdentifier());
        userDTO.setName(entity.getName());
        return userDTO;
    }

}