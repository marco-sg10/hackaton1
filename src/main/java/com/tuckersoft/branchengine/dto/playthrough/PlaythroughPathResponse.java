package com.tuckersoft.branchengine.dto.playthrough;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PlaythroughPathResponse {

    private Long playthroughId;
    private String playerTag;

    private String status;
    private String endingCode;

    private String startNodeCode;
    private String currentNodeCode;

    private List<PathStepResponse> steps;
}
