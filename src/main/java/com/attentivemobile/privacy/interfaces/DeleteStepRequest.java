package com.attentivemobile.privacy.interfaces;

import org.immutables.value.Value;

@Value.Immutable
public interface DeleteStepRequest {
    static Builder builder() {
        return ImmutableDeleteStepRequest.builder();
    }

    long getCompanyId();

    UserIdentities getIdentities();

    interface Builder {
        Builder companyId(long companyId);
        Builder identities(UserIdentities identities);
        DeleteStepRequest build();
    }
}