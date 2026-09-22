package com.tuckersoft.branchengine.service;

import com.tuckersoft.branchengine.dto.user.RoleUpdateRequest;
import com.tuckersoft.branchengine.dto.user.UserResponse;
import com.tuckersoft.branchengine.exception.ApiException;
import com.tuckersoft.branchengine.model.User;
import com.tuckersoft.branchengine.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .displayName(user.getDisplayName())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public UserResponse getCurrentUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "NOT_FOUND", "Usuario no encontrado"));
        return mapToResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public UserResponse updateUserRole(Long id, RoleUpdateRequest request, String currentUserEmail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "NOT_FOUND", "Usuario no encontrado"));

        if (user.getEmail().equals(currentUserEmail)) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "BAD_REQUEST", "No puedes cambiar tu propio rol");
        }

        user.setRole(request.getRole());
        userRepository.save(user);

        return mapToResponse(user);
    }
}
