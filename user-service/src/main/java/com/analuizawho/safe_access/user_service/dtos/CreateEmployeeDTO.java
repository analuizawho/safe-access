package com.analuizawho.safe_access.user_service.dtos;

import com.analuizawho.safe_access.user_service.entities.enums.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEmployeeDTO(
        @NotBlank
        String name,
        @NotBlank
        String position,
        @NotNull
        Department department,
        @NotBlank
        String password) {
}
