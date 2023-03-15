package com.attentivemobile.privacy.services;

import org.immutables.value.Value;

@Value.Immutable
public interface IdentityServiceRequest {

    static IdentityServiceRequest.Builder builder() {
        return ImmutableIdentityServiceRequest.builder();
    }

    long getCompanyId();

    String getPhone();

    String getEmail();

    interface Builder {
        Builder companyId(long companyId);

        Builder phone(String phone);

        Builder email(String email);

        IdentityServiceRequest build();
    }
}
