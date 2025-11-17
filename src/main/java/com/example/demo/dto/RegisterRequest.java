package com.example.demo.dto;


import com.example.demo.Enum.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "Username must not be blank")
        @Size(min = 3, max = 50, message = "Username must be 3-50 characters long")
        String username,

        @NotBlank(message = "Password must not be blank")
        @Size(min = 6, max = 100, message = "Password must be at least 6 characters")
        // Regex: Ít nhất 1 chữ hoa, 1 số, 1 ký tự đặc biệt
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
                message = "It must contain at least one uppercase letter, one digit, and one special character")
        String password,

        @NotNull(message = "Role must not be null")
        Role role
) {}