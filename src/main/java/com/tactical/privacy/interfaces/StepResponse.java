package com.tactical.privacy.interfaces;

import java.time.LocalDateTime;
import org.immutables.value.Value;
import com.tactical.privacy.models.StepStatus;

@Value.Immutable
public interface StepResponse {
    static Builder builder() {
        return ImmutableStepResponse.builder();
    }

    //TO DO: create STEPSTATUS enum
    StepStatus getStepStatus();

    LocalDateTime getTimeStamp();

    String[] getMessages();

    interface Builder {
        Builder stepStatus(StepStatus stepStatus);

        Builder timeStamp(LocalDateTime timeStamp);

        Builder messages(String[] messages);

        StepResponse build();
    }
}
