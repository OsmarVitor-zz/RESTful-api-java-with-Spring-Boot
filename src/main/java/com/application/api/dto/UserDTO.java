package com.application.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    private String name;

    @JsonProperty("birth_date")
    private LocalDate birthDate;

    public String identifier;

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "UserDTO [name=" + name + ", birthDate=" + birthDate
                + ", identifier=" + identifier + "]";
    }

}
