package com.tuckersoft.branchengine.dto.user;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String email;
    private String displayName;
    private String role;
    private Instant createdAt;
}
