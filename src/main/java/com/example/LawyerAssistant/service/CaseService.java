package com.example.LawyerAssistant.service;

import com.example.LawyerAssistant.exceptions.ApiException;
import com.example.LawyerAssistant.model.MyCase;
import com.example.LawyerAssistant.repository.CaseRepository;
import com.example.LawyerAssistant.validation.CaseForm;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CaseService {
    private final CaseRepository caseRepository;
    public String addCase(CaseForm caseForm) {
        caseRepository.save(MyCase.builder()
                .id(caseForm.getId())
                .city(caseForm.getCity())
                .status(caseForm.getStatus())
                .title(caseForm.getTitle())
                .description(caseForm.getDescription())
                .build());
        return "case add !!";
    }

    public List<MyCase> allCases() {
        return caseRepository.findAll();
    }

    public MyCase caseById(String id) {
        MyCase cas = caseRepository.findById(id).orElseThrow(()->new ApiException("There is not case with this id"));
        return cas;
    }

    public String updateCase(String caseId, Map<String, Object> updatedCase) {
        MyCase existingMyCase = caseRepository.findById(caseId).orElseThrow(() -> new EntityNotFoundException("Case not found"));
        for (String fieldName : updatedCase.keySet()) {
            try {
                Field field = existingMyCase.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object newValue = updatedCase.get(fieldName);
                field.set(existingMyCase, newValue);
            }catch (Exception e){
                return e.getMessage();
            }
        }
        caseRepository.save(existingMyCase);
        return "case updated !!";
    }

    public String deleteCase(String caseId) {
        caseRepository.deleteById(caseId);
        return "case deleted !!";
    }
}
