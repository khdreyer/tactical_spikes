package com.tactical.privacy.interfaces;

import org.immutables.value.Value;

@Value.Immutable
public interface UserIdentities {

    static Builder builder() {
        return ImmutableUserIdentities.builder();
    }

    String getPhone();

    String getEmail();

    long getSubscriberId();

    String getVisitorId();

    interface Builder {
        Builder phone(String phone);

        Builder email(String email);

        Builder subscriberId(long subscriberId);

        Builder visitorId(String visitorId);

        UserIdentities build();
    }
}
