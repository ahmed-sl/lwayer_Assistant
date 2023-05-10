package com.example.LawyerAssistant.validation;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class CaseForm {
    @NotEmpty(message = "id is required !!")
    private String id;
    @NotEmpty(message = "city is required !!")
    private String city;
    @NotEmpty(message = "status is required !!")
    private String status;
    @NotEmpty(message = "title is required !!")
    private String title;
    @NotEmpty(message = "description is required !!")
    private String description;
}
