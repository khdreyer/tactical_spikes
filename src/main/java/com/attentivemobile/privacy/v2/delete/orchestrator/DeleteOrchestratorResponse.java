package com.attentivemobile.privacy.v2.delete.orchestrator;

import com.attentivemobile.privacy.v2.delete.steps.interfaces.DeleteStepResponse;
import java.time.LocalDateTime;
import org.immutables.value.Value;

@Value.Immutable
public interface DeleteOrchestratorResponse {
    static Builder builder() {
        return ImmutableDeleteOrchestratorResponse.builder();
    }

    long getCompanyId();

    LocalDateTime getStartedAt();

    LocalDateTime getEndedAt();

    DeleteStepResponse[] getStepResults();

    interface Builder {

        Builder companyId(long companyId);

        Builder startedAt(LocalDateTime start);

        Builder endedAt(LocalDateTime end);

        Builder stepResults(DeleteStepResponse[] deleteStepRespons);

        DeleteOrchestratorResponse build();
    }
}