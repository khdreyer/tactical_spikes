package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.DeleteStepStatus;
import com.tactical.privacy.models.DeleteStepType;
import java.time.LocalTime;
import org.immutables.value.Value;

@Value.Immutable
public interface DeleteStepResponse {
    static Builder builder() { return ImmutableDeleteStepResponse.builder(); }

    DeleteStepType getStepType();

    DeleteStepStatus getStepStatus();

    LocalTime getStartedAt();

    LocalTime getEndedAt();

    @Value.Default
    default String[] getMessages()  {
        return new String[] {};
    }

    interface Builder {
        Builder stepType(DeleteStepType type);

        Builder stepStatus(DeleteStepStatus status);

        Builder startedAt(LocalTime started);

        Builder endedAt(LocalTime ended);

        Builder messages(String[] messages);

        DeleteStepResponse build();
    }
}
