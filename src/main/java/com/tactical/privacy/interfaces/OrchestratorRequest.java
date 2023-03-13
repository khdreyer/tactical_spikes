package com.tactical.privacy.interfaces;

import com.tactical.privacy.models.PrivacyDeleteStepType;
import org.immutables.value.Value;

@Value.Immutable
public interface OrchestratorRequest {
    static Builder builder() {
        return ImmutableOrchestratorRequest.builder();
    }

    long getCompanyId();

    String getPhone();

    String getEmail();

    long getSubscriberId();

    String getVisitorId();

    @Value.Default
    default PrivacyDeleteStepType[] getStepsToProcess()  {
        return new PrivacyDeleteStepType[] {};
    }

    interface Builder {
        Builder companyId(long companyId);

        Builder phone(String phone);

        Builder email(String email);

        Builder subscriberId(long subscriberId);

        Builder visitorId(String visitorId);

        Builder stepsToProcess(PrivacyDeleteStepType[] steps);

        OrchestratorRequest build();
    }
}
