package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.PrivacyDeleteStepType;
import org.immutables.value.Value;

@Value.Immutable
public interface OrchestratorRequest {
    static Builder builder() {
        return ImmutableOrchestratorRequest.builder();
    }

    long getCompanyId();

    UserIdentities getUserIdentities();

    @Value.Default
    default PrivacyDeleteStepType[] getStepsToProcess()  {
        return new PrivacyDeleteStepType[] {};
    }

    interface Builder {
        Builder companyId(long companyId);
        Builder userIdentities(UserIdentities userIdentities);

        Builder stepsToProcess(PrivacyDeleteStepType[] steps);

        OrchestratorRequest build();
    }
}
