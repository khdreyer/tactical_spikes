package com.attentivemobile.privacy.v2.delete.steps.utils;

import com.attentivemobile.privacy.v2.delete.stats.StepMessages;
import com.attentivemobile.privacy.v2.delete.steps.enums.DeleteStepStatus;
import com.attentivemobile.privacy.v2.delete.steps.enums.DeleteStepType;
import com.attentivemobile.privacy.v2.delete.steps.interfaces.DeleteStepResponse;
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
