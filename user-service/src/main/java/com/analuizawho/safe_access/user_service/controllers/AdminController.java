package com.analuizawho.safe_access.user_service.controllers;

import com.analuizawho.safe_access.user_service.dtos.CreateAdminDTO;
import com.analuizawho.safe_access.user_service.dtos.InfoAdminDTO;
import com.analuizawho.safe_access.user_service.dtos.UpdateAdminDTO;
import com.analuizawho.safe_access.user_service.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-service/admin")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InfoAdminDTO> createAdmin (@RequestBody @Valid CreateAdminDTO createDTO){
        var admin = service.createAdmin(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoAdminDTO> infoAdmin(Long id ){
        var admin = service.infoAdmin(id);
        return ResponseEntity.ok(admin);
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<List<InfoAdminDTO>> listAdmin(){
        var admin = service.listAdmin();
        return ResponseEntity.ok(admin);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<InfoAdminDTO> updateAdmin(@PathVariable Long id, @RequestBody UpdateAdminDTO updateDTO){
        var admin = service.updateAdmin(id, updateDTO);
        return ResponseEntity.ok(admin);
    }

    @PutMapping("activate/{id}")
    public ResponseEntity<Void> activateAdmin(Long id){
        service.activateAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("deactivate/{id}")
    public ResponseEntity<Void> softDeleteAdmin(@PathVariable Long id){
        service.softDeleteAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        service.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
