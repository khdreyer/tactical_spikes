package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.StepType;
import org.immutables.value.Value;

@Value.Immutable
public interface OrchestratorRequest {
    static Builder builder() {
        return ImmutableOrchestratorRequest.builder();
    }

    int getCompanyId();

    String getPhone();

    String getEmail();

    @Value.Default
    default StepType[] getStepsToProcess()  {
        return new StepType[] {};
    }

    interface Builder {
        Builder companyId(int companyId);

        Builder phone(String phone);

        Builder email(String email);

        Builder stepsToProcess(StepType[] steps);

        OrchestratorRequest build();
    }
}
