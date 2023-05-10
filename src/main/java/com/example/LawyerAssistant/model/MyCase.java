package com.example.LawyerAssistant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
@Builder
public class MyCase {
    @Id
    @Column(unique = true,nullable = false)
    private String id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

}
