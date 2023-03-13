package com.tactical.privacy.interfaces;

import org.immutables.value.Value;

@Value.Immutable
public interface Identities {

    static Builder builder() {
        return ImmutableIdentities.builder();
    }

    String getPhone();

    String getEmail();

    Long getSubscriberId();

    String getVisitorId();

    interface Builder {
        Builder phone(String phone);

        Builder email(String email);

        Builder subscriberId(Long subscriberId);

        Builder visitorId(String visitorId);

        Identities build();
    }
}
