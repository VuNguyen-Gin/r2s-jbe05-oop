package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.AuthService;
import com.example.demo.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService authService;
    private final JwtService jwtService;


    @Autowired
    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<RequestResponse> register(@Valid @RequestBody RegisterRequest req) {

        return ResponseEntity.ok(authService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest req) {
        return ResponseEntity.ok(authService.login(req));
    }


    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @Valid @RequestBody ChangePasswordRequest req
    ) {
        // 1. Giải mã token thủ công
        String token = authHeader.substring(7);

        // Bây giờ 'jwtService' đã được khai báo, dòng này sẽ hết lỗi
        String username = jwtService.extractUsername(token);

        // 2. Gọi service (dùng biến 'authService')
        authService.changePassword(username, req);

        // 3. Trả về 204 No Content
        return ResponseEntity.noContent().build();
    }
}