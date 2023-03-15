package com.tactical.privacy.steps;

import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.interfaces.DeleteStepRequest;
import com.tactical.privacy.interfaces.DeleteStepResponse;
import com.tactical.privacy.steps.enums.DeleteStepStatus;
import com.tactical.privacy.steps.enums.DeleteStepType;
import com.tactical.privacy.stats.Logger;
import com.tactical.privacy.stats.StepMessages;
import com.tactical.privacy.steps.utils.DeleteStepCommonResponseBuilder;
import java.time.LocalTime;

public class SubscriberMainMySqlDeleteStep implements DeleteStep {

    private static final Logger LOG = Logger.getLogger(SubscriberMainMySqlDeleteStep.class);
    private final DeleteStepCommonResponseBuilder commonResponseBuilder;

    public SubscriberMainMySqlDeleteStep(
        DeleteStepCommonResponseBuilder commonResponseBuilder)
    {
        this.commonResponseBuilder = commonResponseBuilder;
    }

    @Override
    public DeleteStepType getType() {
        return DeleteStepType.SUBSCRIBER_MAIN_MYSQL;
    }

    @Override
    public DeleteStepResponse process(DeleteStepRequest stepRequest) {
        LocalTime startedAt = LocalTime.now();
        String stepName = this.getClass().getSimpleName();

        LOG.info(String.format(StepMessages.STEP_STARTED, stepName));

        // TODO: call service. Do not throw. Just capture the exception and mark it as failed.

        DeleteStepResponse response = DeleteStepResponse.builder()
            .stepType(getType())
            .startedAt(startedAt)
            .endedAt(LocalTime.now())
            .stepStatus(DeleteStepStatus.SUCCESS)
            .build();

        LOG.info(String.format(StepMessages.STEP_ENDED, stepName));

        return response;
    }

    @Override
    public DeleteStepResponse skip(DeleteStepRequest stepRequest) {
        return commonResponseBuilder.getSkippedResponse(getType());
    }
}