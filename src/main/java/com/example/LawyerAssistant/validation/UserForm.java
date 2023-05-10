package com.example.LawyerAssistant.validation;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor @NoArgsConstructor @Data
public class UserForm {

    @NotEmpty(message = "username is required !!")
    private String username;
    @Email(message = "email must be valid !!")
    @NotEmpty(message = "email is required !!")
    private String email;
    @NotEmpty(message = "password is required !!")
    private String password;
    @NotEmpty(message = "role is required !!")
    @Pattern(regexp = "(i)admin|user")
    private String role;
    @NotEmpty(message = "degree is required !!")
    private String degree;
}
