package com.application.api.dto;

public class UserDTO {

    private String name;
    private String birthDate;
    public String identifier;

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String BirthDate) {
        this.birthDate = BirthDate;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "UserDTO [name=" + name + ", age=" + birthDate + ", identifier="
                + identifier + "]";
    }

}
