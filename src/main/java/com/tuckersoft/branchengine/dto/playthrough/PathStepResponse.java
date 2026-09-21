package com.tuckersoft.branchengine.dto.playthrough;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class PathStepResponse {

    private Integer order;
    private Long decisionId;

    private String fromNodeCode;
    private String toNodeCode;

    private String branchType;
    private String impactLevel;

    private Instant createdAt;
}
