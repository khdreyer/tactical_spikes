package com.tactical.privacy.steps;

import com.tactical.privacy.interfaces.Step;
import com.tactical.privacy.interfaces.StepRequest;
import com.tactical.privacy.interfaces.StepResponse;
import com.tactical.privacy.models.PrivacyDeleteStepType;
import com.tactical.privacy.models.StepStatus;
import com.tactical.privacy.stats.Logger;
import java.time.LocalTime;

public class SubscriberMainMySqlDeleteStep implements Step {

    private static final Logger LOG = Logger.getLogger(SubscriberMainMySqlDeleteStep.class);

    @Override
    public PrivacyDeleteStepType getType() {
        return PrivacyDeleteStepType.SUBSCRIBER_MAIN_MYSQL_DELETE;
    }

    @Override
    public StepResponse process(StepRequest stepRequest) {
        var startedAt = LocalTime.now();
        var stepName = this.getClass().getSimpleName();

        LOG.info("Processing started for  -> " + stepName);

        var response = StepResponse.builder()
            .stepType(getType())
            .startedAt(startedAt)
            .endedAt(LocalTime.now())
            .stepStatus(StepStatus.SUCCESS)
            .build();

        LOG.info("Processing ended for  -> " + stepName);

        return response;
    }
}

