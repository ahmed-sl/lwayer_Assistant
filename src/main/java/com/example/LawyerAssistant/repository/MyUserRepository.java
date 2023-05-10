package com.example.LawyerAssistant.repository;

import com.example.LawyerAssistant.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser,String> {
}
