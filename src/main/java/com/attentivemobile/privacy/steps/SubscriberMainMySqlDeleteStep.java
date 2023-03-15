package com.attentivemobile.privacy.steps;

import com.attentivemobile.privacy.interfaces.DeleteStep;
import com.attentivemobile.privacy.interfaces.DeleteStepRequest;
import com.attentivemobile.privacy.interfaces.DeleteStepResponse;
import com.attentivemobile.privacy.stats.Logger;
import com.attentivemobile.privacy.stats.StepMessages;
import com.attentivemobile.privacy.steps.enums.DeleteStepStatus;
import com.attentivemobile.privacy.steps.enums.DeleteStepType;
import com.attentivemobile.privacy.steps.utils.DeleteStepCommonResponseBuilder;
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