package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record ChangePasswordRequest(
        @NotBlank
        String oldPassword,

        @NotBlank
        @Size(min = 6, max = 100, message = "Password must be at least 6 characters")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
                message = "It must contain at least one uppercase letter, one digit, and one special character")
        String newPassword,

        @NotBlank
        String confirmNewPassword
) {}