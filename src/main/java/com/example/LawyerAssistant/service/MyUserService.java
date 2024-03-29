package com.example.LawyerAssistant.service;

import com.example.LawyerAssistant.model.MyUser;
import com.example.LawyerAssistant.repository.MyUserRepository;
import com.example.LawyerAssistant.validation.UserForm;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;
    public String addUser(UserForm userForm) {

        myUserRepository.save(MyUser.builder()
                .username(userForm.getUsername())
                        .password(userForm.getPassword())
                        .degree(userForm.getDegree())
                        .email(userForm.getEmail())
                        .phoneNumber(userForm.getPhoneNumber())
                        .role(userForm.getRole())
                .build());
        return "user add !!";
    }

    public List<MyUser> getAllUsers() {
        return myUserRepository.findAll();
    }

    public String updateUser(String userId, Map<String,Object> updates)  {
        MyUser existingUser = myUserRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        for (String fieldName : updates.keySet()) {
            try {
                Field field = existingUser.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object newValue = updates.get(fieldName);
                field.set(existingUser, newValue);
            }catch (Exception e){
                return e.getMessage();
            }
        }
        myUserRepository.save(existingUser);
        return "user updated !!";
    }

    public String deleteUser(String id) {
        myUserRepository.deleteById(id);
        return "user deleted !!";
    }
}
