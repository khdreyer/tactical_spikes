package com.tactical.privacy.interfaces;

import java.time.LocalDateTime;
import org.immutables.value.Value;

@Value.Immutable
public interface OrchestratorResponse {
    static Builder builder() {
        return ImmutableOrchestratorResponse.builder();
    }

    LocalDateTime getStartedAt();

    LocalDateTime getEndedAt();

    StepResponse[] getStepResults();

    interface Builder {

        Builder startedAt(LocalDateTime start);

        Builder endedAt(LocalDateTime end);

        Builder stepResults(StepResponse[] stepResponses);

        OrchestratorResponse build();
    }
}