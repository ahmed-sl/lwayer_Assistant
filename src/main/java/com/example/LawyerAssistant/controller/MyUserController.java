package com.example.LawyerAssistant.controller;

import com.example.LawyerAssistant.DTO.API;
import com.example.LawyerAssistant.model.MyUser;
import com.example.LawyerAssistant.service.MyUserService;
import com.example.LawyerAssistant.validation.UserForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyUserController {

    private final MyUserService myUserService;
    String message;

    @GetMapping("/users")
    public ResponseEntity<List<MyUser>> getAllUsers(){
        return ResponseEntity.status(201).body(myUserService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<API> test(@Valid @RequestBody UserForm myUser, Errors errors){
    if (errors.hasErrors()){
        return ResponseEntity.status(400).body(new API(errors.getFieldError().getDefaultMessage(),401));
     }
    message = myUserService.addUser(myUser);
    return ResponseEntity.status(200).body(new API(message,200));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<API> updateUser(@PathVariable String id,
                                              @RequestBody Map<String,Object> updates,
                                             Errors errors) throws Exception {
        if (errors.hasErrors()){
            return ResponseEntity.status(401).body(new API(errors.getFieldError().getDefaultMessage(),401));
        }
        message = myUserService.updateUser(id,updates);
        return ResponseEntity.status(201).body(new API(message,200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<API> deleteUser(@PathVariable String id){
        message = myUserService.deleteUser(id);
        return ResponseEntity.status(200).body(new API(message,200));
    }
}
