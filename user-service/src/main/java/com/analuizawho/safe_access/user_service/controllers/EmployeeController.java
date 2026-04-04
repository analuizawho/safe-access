package com.analuizawho.safe_access.user_service.controllers;

import com.analuizawho.safe_access.user_service.dtos.CreateEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.InfoEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.ListEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.UpdateEmployeeDTO;
import com.analuizawho.safe_access.user_service.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InfoEmployeeDTO> createEmployee(@RequestBody @Valid CreateEmployeeDTO createDTO){
        var employee = service.createEmployee(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoEmployeeDTO> infoEmployee(@PathVariable Long id) {
        var employee = service.infoEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfoEmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDTO updateDTO){
        var employee = service.updateEmployee(id, updateDTO);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Void> activateEmployee(@PathVariable Long id) {
        service.activateEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateEmployee(@PathVariable Long id) {
        service.softDeleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
