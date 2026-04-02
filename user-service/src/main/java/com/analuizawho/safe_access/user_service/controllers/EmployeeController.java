package com.analuizawho.safe_access.user_service.controllers;

import com.analuizawho.safe_access.user_service.dtos.CreateEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.InfoEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.ListEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.UpdateEmployeeDTO;
import com.analuizawho.safe_access.user_service.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InfoEmployeeDTO> createEmployee(@PathVariable Long id, @RequestBody CreateEmployeeDTO createDTO){
        var employee = service.createEmployee(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<InfoEmployeeDTO> infoEmployee(@PathVariable Long id) {
        var employee = service.infoEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<ListEmployeeDTO>> listEmployee(){
        var employee = service.listEmployee();
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InfoEmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDTO updateDTO){
        var employee = service.updateEmployee(id, updateDTO);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<Void> activateEmployee(@PathVariable Long id) {
        service.activateEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deactivate/{id}")
    public ResponseEntity<Void> deactivateEmployee(@PathVariable Long id) {
        service.activateEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.activateEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
