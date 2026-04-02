package com.analuizawho.safe_access.user_service.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAdminDTO(
        @NotBlank
        String name,
        @NotNull
        String department,
        @NotBlank
        String password) {
}
