package com.tactical.privacy.steps.utils;

import com.tactical.privacy.interfaces.DeleteStepResponse;
import com.tactical.privacy.steps.enums.DeleteStepStatus;
import com.tactical.privacy.steps.enums.DeleteStepType;
import com.tactical.privacy.stats.StepMessages;
import java.time.LocalTime;

public class DeleteStepCommonResponseBuilder {
    public DeleteStepResponse getSkippedResponse(DeleteStepType stepType) {
        String stepName = stepType.toString();
        var msg = String.format(StepMessages.STEP_SKIPPED, stepName);

        return DeleteStepResponse.builder()
            .stepType(stepType)
            .startedAt(LocalTime.now())
            .endedAt(LocalTime.now())
            .stepStatus(DeleteStepStatus.SKIPPED)
            .messages(new String[] {msg})
            .build();
    }
}
