package com.attentivemobile.privacy.steps.utils;

import com.attentivemobile.privacy.interfaces.DeleteStepResponse;
import com.attentivemobile.privacy.stats.StepMessages;
import com.attentivemobile.privacy.steps.enums.DeleteStepStatus;
import com.attentivemobile.privacy.steps.enums.DeleteStepType;
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
