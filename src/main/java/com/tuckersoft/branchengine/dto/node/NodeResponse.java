package com.tuckersoft.branchengine.dto.node;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

@Data
@Builder
public class NodeResponse {
    private Long id;
    private String nodeCode;
    private String title;
    private String sceneText;
    private Integer branchCapacity;
    private Integer currentBranches;
    private String primaryBranchCode;
    private String glitchBranchCode;
    private Instant createdAt;
}
