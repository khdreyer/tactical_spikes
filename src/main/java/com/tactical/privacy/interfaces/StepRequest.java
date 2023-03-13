package com.tactical.privacy.interfaces;

import org.immutables.value.Value;

@Value.Immutable
public interface StepRequest {
    static Builder builder() {
        return ImmutableStepRequest.builder();
    }

    long getCompanyId();

    UserIdentities getIdentities();

    interface Builder {
        Builder companyId(long companyId);
        Builder identities(UserIdentities identities);
        StepRequest build();
    }
}