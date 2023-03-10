package com.tactical.privacy.interfaces;

import org.immutables.value.Value;

@Value.Immutable
public interface StepRequest {
    static Builder builder() {
        return ImmutableStepRequest.builder();
    }

    String getPhone();

    String getEmail();

    int getCompanyId();

    interface Builder {
        Builder phone(String phone);

        Builder email(String email);

        Builder companyId(int companyId);

        StepRequest build();

    }

}