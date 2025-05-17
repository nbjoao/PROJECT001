package dev.byte_forge.project001.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateRequestDTO {

    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "password")
    private String password;

    public UserCreateRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserCreateRequestDTO() {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
