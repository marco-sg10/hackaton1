package com.tuckersoft.branchengine.controller;

import com.tuckersoft.branchengine.dto.user.RoleUpdateRequest;
import com.tuckersoft.branchengine.dto.user.UserResponse;
import com.tuckersoft.branchengine.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getMe(Authentication authentication) {
        return userService.getCurrentUser(authentication.getName());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PatchMapping("/{id}/role")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateRole(@PathVariable Long id, @Valid @RequestBody RoleUpdateRequest request, Authentication authentication) {
        return userService.updateUserRole(id, request, authentication.getName());
    }
}
