package com.example.LawyerAssistant.controller;

import com.example.LawyerAssistant.DTO.API;
import com.example.LawyerAssistant.model.MyCase;
import com.example.LawyerAssistant.service.CaseService;
import com.example.LawyerAssistant.validation.CaseForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/case")
@RequiredArgsConstructor
public class CaseController {
    private final CaseService caseService;
    String message;

    @PostMapping("/add")
    public ResponseEntity<API> addCase(@Valid @RequestBody CaseForm caseForm, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(401).body(new API(errors.getFieldError().getDefaultMessage(),401));
        }
        message = caseService.addCase(caseForm);
       return ResponseEntity.status(201).body(new API(message,200));
    }
    @GetMapping("/cases")
    public ResponseEntity<List<MyCase>> allCases(){
        return ResponseEntity.status(200).body(caseService.allCases());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MyCase> caseById(@PathVariable String id){
        return ResponseEntity.status(200).body(caseService.caseById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<API> updateCase(@PathVariable String id,
                                          @RequestBody Map<String, Object> updatedCase,
                                          Errors errors){
        if (errors.hasErrors()){
            message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(401).body(new API(message,401));
        }
        message = caseService.updateCase(id,updatedCase);
        return ResponseEntity.status(200).body(new API(message,200));
    }
    @DeleteMapping("/delete/{caseId}")
    public ResponseEntity<API> deleteCase(@PathVariable String caseId){
        message = caseService.deleteCase(caseId);
        return ResponseEntity.status(200).body(new API(message,200));
    }
}
