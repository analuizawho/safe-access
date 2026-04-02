package com.analuizawho.safe_access.user_service.dtos;

import com.analuizawho.safe_access.user_service.entities.enums.Department;

public record InfoAdminDTO(
        Long id,
        String name,
        Department department
) {
}
