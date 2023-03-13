package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.StepStatus;
import com.tactical.privacy.models.StepType;
import java.time.LocalTime;
import org.immutables.value.Value;

@Value.Immutable
public interface StepResponse {
    static Builder builder() { return ImmutableStepResponse.builder(); }

    StepType getStepType();

    StepStatus getStepStatus();

    LocalTime getStartedAt();

    LocalTime getEndedAt();

    @Value.Default
    default String[] getMessages()  {
        return new String[] {};
    }

    interface Builder {
        Builder stepType(StepType type);

        Builder stepStatus(StepStatus status);

        Builder startedAt(LocalTime started);

        Builder endedAt(LocalTime ended);

        Builder messages(String[] messages);

        StepResponse build();
    }
}
