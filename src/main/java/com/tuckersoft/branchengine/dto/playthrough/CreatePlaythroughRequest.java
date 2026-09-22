package com.tuckersoft.branchengine.dto.playthrough;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePlaythroughRequest {

    @NotBlank
    @Size(min = 2, max = 40)
    private String playerTag;

    @NotBlank
    @Size(min = 3, max = 40)
    private String startNodeCode;
}
