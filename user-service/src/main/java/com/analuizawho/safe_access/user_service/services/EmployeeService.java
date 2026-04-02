package com.analuizawho.safe_access.user_service.services;

import com.analuizawho.safe_access.user_service.dtos.CreateEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.InfoEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.ListEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.UpdateEmployeeDTO;
import com.analuizawho.safe_access.user_service.mappers.EmployeeMapper;
import com.analuizawho.safe_access.user_service.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public InfoEmployeeDTO createEmployee(CreateEmployeeDTO createDTO){
        var newEmployee = mapper.toEmployee(createDTO);

        var employee = repository.save(newEmployee);

        return mapper.toInfo(employee);
    }

    @Transactional
    public InfoEmployeeDTO infoEmployee(Long id){
        var employee = repository.getReferenceById(id);

        return mapper.toInfo(employee);
    }

    @Transactional
    public List<ListEmployeeDTO> listEmployee(){
        var employee = repository.findAllByEmployeeActiveTrue();
        return mapper.toList(employee);
    }

    @Transactional
    public InfoEmployeeDTO updateEmployee(Long id, UpdateEmployeeDTO updateDTO){
        var employee = repository.getReferenceById(id);
        employee.updateEmployeeInfo(updateDTO);
        employee = repository.save(employee);
        return mapper.toInfo(employee);
    }

    @Transactional
    public void activateEmployee(Long id){
        var employee = repository.getReferenceById(id);
        employee.setEmployeeActivated();
    }

    @Transactional
    public void softDeleteEmployee(Long id) {
        var employee = repository.getReferenceById(id);
        employee.setEmployeeInactivated();
    }

    @Transactional
    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }
}
