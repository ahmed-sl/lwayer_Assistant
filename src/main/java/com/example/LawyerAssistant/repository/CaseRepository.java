package com.example.LawyerAssistant.repository;

import com.example.LawyerAssistant.model.MyCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<MyCase,String> {
}
