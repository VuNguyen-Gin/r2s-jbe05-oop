package com.example.demo.service;

import com.example.demo.Enum.Role;
import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.NotFoundException; // Dùng exception đã có
import com.example.demo.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt; // Import jbcrypt
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final JwtService jwt;

    public AuthService(UserRepository userRepo, JwtService jwt) {
        this.userRepo = userRepo;
        this.jwt = jwt;
    }

    @Transactional
    public RequestResponse register(RegisterRequest req) {
        if (userRepo.existsByUsername(req.username())) {

            throw new NotFoundException("Username already exists");
        }
        User u = new User();
        u.setUsername(req.username());
        u.setPasswordHash(BCrypt.hashpw(req.password(), BCrypt.gensalt()));
        u.setRole(req.role() == null ? Role.USER : req.role());

        User savedUser = userRepo.save(u);
        return new RequestResponse(savedUser.getUsername(), savedUser.getRole().toString());
    }

    @Transactional(readOnly = true)
    public AuthResponse login(AuthRequest req) {
        var u = userRepo.findByUsername(req.username())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid credentials"));

        if (!BCrypt.checkpw(req.password(), u.getPasswordHash())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return new AuthResponse(jwt.generateToken(u));
    }
    @Transactional
    public void changePassword(String username, ChangePasswordRequest req) {
        // 1. Tìm user
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        // 2. Kiểm tra mật khẩu cũ
        if (!BCrypt.checkpw(req.oldPassword(), user.getPasswordHash())) {
            throw new InvalidCredentialsException("Current password is incorrect");
        }

        // 3. Kiểm tra trùng khớp mật khẩu mới
        if (!req.newPassword().equals(req.confirmNewPassword())) {
            throw new IllegalArgumentException("New password confirmation does not match");
        }

        // 4. Kiểm tra mật khẩu mới phải khác mật khẩu cũ
        // (Lưu ý: so sánh raw newPass với hashed oldPass bằng checkpw)
        if (BCrypt.checkpw(req.newPassword(), user.getPasswordHash())) {
            throw new IllegalArgumentException("New password must be different from the current password");
        }

        // 5. Cập nhật mật khẩu mới
        user.setPasswordHash(BCrypt.hashpw(req.newPassword(), BCrypt.gensalt()));
        userRepo.save(user);
    }
}