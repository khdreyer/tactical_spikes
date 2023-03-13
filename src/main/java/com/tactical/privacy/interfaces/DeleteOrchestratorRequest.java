package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.DeleteStepType;
import org.immutables.value.Value;

@Value.Immutable
public interface DeleteOrchestratorRequest {
    static Builder builder() {
        return ImmutableDeleteOrchestratorRequest.builder();
    }

    long getCompanyId();

    UserIdentities getUserIdentities();

    @Value.Default
    default DeleteStepType[] getStepsToProcess()  {
        return new DeleteStepType[] {};
    }

    interface Builder {
        Builder companyId(long companyId);

        Builder userIdentities(UserIdentities userIdentities);

        Builder stepsToProcess(DeleteStepType[] steps);

        DeleteOrchestratorRequest build();
    }
}
