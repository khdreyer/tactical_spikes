package com.attentivemobile.privacy.services;

import org.immutables.value.Value;

@Value.Immutable
public interface IdentityServiceResponse {

    static IdentityServiceResponse.Builder builder() {
        return ImmutableIdentityServiceResponse.builder();
    }

    String getVisitorId();

    long getSubscriberId();

    interface Builder {

        Builder visitorId(String visitorId);

        Builder subscriberId(long subscriberId);

        IdentityServiceResponse build();
    }
}

