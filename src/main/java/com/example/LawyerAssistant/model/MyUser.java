package com.example.LawyerAssistant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Builder
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
//    @NotEmpty(message = "username is required !!")
    @Column(unique = true,nullable = false)
    private String username;
//    @Email(message = "email must be valid !!")
//    @NotEmpty(message = "email is required !!")
    @Column(unique = true,nullable = false)
    private String email;
//    @NotEmpty(message = "password is required !!")
    @Column(nullable = false)
    private String password;
//    @NotEmpty(message = "role is required !!")
    @Pattern(regexp = "(i)admin|user")
    private String role;
//    @NotEmpty(message = "degree is required !!")
    private String degree;
}
