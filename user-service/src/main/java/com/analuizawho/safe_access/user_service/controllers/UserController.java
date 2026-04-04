package com.analuizawho.safe_access.user_service.controllers;

import com.analuizawho.safe_access.user_service.dtos.InfoUserDTO;
import com.analuizawho.safe_access.user_service.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-service/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<InfoUserDTO>> listAllUsers(){
        var user = service.listAllUsers();
        return ResponseEntity.ok(user);
    }
}
