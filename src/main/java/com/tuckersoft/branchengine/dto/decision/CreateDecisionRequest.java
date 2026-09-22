package com.tuckersoft.branchengine.dto.decision;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateDecisionRequest {

    @NotNull
    private Long playthroughId;

    @NotBlank
    @Size(min = 10)
    private String rawInput;

    @NotBlank
    @Pattern(
        regexp = "LEVE|MODERADO|GRAVE|CRITICO",
        message = "impactLevel debe ser LEVE, MODERADO, GRAVE o CRITICO"
    )
    private String impactLevel;
}
