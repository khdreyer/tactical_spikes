package com.tactical.privacy.steps;

import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.interfaces.DeleteStepRequest;
import com.tactical.privacy.interfaces.DeleteStepResponse;
import com.tactical.privacy.models.DeleteStepStatus;
import com.tactical.privacy.models.DeleteStepType;
import com.tactical.privacy.stats.Logger;
import java.time.LocalTime;

public class SubscriberMainMySqlDeleteStep implements DeleteStep {

    private static final Logger LOG = Logger.getLogger(SubscriberMainMySqlDeleteStep.class);

    @Override
    public DeleteStepType getType() {
        return DeleteStepType.SUBSCRIBER_MAIN_MYSQL_DELETE;
    }

    @Override
    public DeleteStepResponse process(DeleteStepRequest stepRequest) {
        LocalTime startedAt = LocalTime.now();
        String stepName = this.getClass().getSimpleName();

        LOG.info("Processing started for  -> " + stepName);

        DeleteStepResponse response = DeleteStepResponse.builder()
            .stepType(getType())
            .startedAt(startedAt)
            .endedAt(LocalTime.now())
            .stepStatus(DeleteStepStatus.SUCCESS)
            .build();

        LOG.info("Processing ended for  -> " + stepName);

        return response;
    }
}