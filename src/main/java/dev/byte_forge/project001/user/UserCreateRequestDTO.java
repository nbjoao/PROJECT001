package dev.byte_forge.project001.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.byte_forge.project001.validation.StrongPassword;
import jakarta.validation.constraints.Email;

public class UserCreateRequestDTO {

    @JsonProperty(value = "email")
    @Email
    private String email;
    @StrongPassword
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

    public void setPassword(String password) {
        this.password = password;
    }

}
