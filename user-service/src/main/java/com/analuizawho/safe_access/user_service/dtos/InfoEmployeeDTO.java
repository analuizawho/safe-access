package com.analuizawho.safe_access.user_service.dtos;

import com.analuizawho.safe_access.user_service.entities.enums.Department;

import java.time.LocalDateTime;

public record InfoEmployeeDTO(Long id,
        String name,
        String position,
        Department department,
        LocalDateTime entryTime,
        LocalDateTime exitTime) {
}
