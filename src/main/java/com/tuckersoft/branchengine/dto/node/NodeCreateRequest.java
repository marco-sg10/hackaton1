package com.tuckersoft.branchengine.dto.node;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NodeCreateRequest {

    @NotBlank
    @Size(min = 3, max = 40)
    private String nodeCode;

    @NotBlank
    @Size(min = 3, max = 80)
    private String title;

    @NotBlank
    @Size(min = 10)
    private String sceneText;

    @NotNull
    @Min(1)
    private Integer branchCapacity;

    private String primaryBranchCode;
    private String glitchBranchCode;
}
