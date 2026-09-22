package com.tuckersoft.branchengine.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RoleUpdateRequest {
    @NotBlank(message = "El rol es obligatorio")
    @Pattern(regexp = "^(ROLE_USER|ROLE_ADMIN)$", message = "Rol inválido")
    private String role;
}
