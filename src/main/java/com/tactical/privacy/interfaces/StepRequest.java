package com.tactical.privacy.interfaces;

import org.immutables.value.Value;

@Value.Immutable
public interface StepRequest {
    static Builder builder() {
        return ImmutableStepRequest.builder();
    }

    int getCompanyId();

    Identities getIdentities();

    interface Builder {
        Builder companyId(int companyId);
        Builder identities(Identities identities);
        StepRequest build();
    }
}