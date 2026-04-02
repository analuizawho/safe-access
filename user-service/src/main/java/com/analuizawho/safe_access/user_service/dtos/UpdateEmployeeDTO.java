package com.analuizawho.safe_access.user_service.dtos;

import com.analuizawho.safe_access.user_service.entities.enums.Department;

import java.time.LocalDateTime;

public record UpdateEmployeeDTO(String name,
                                String position,
                                Department department,
                                LocalDateTime entryTime,
                                LocalDateTime exitTime,
                                String password) {
}
