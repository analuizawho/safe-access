package com.analuizawho.safe_access.user_service.mappers;

import com.analuizawho.safe_access.user_service.dtos.CreateEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.InfoEmployeeDTO;
import com.analuizawho.safe_access.user_service.dtos.ListEmployeeDTO;
import com.analuizawho.safe_access.user_service.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    InfoEmployeeDTO toInfo(Employee employee);

    Employee toEmployee(CreateEmployeeDTO createDTO);

    @Mapping(target = "id", ignore = true)
    List<ListEmployeeDTO> toList(List<Employee> employee);
}
