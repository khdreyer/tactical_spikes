package com.tactical.privacy.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutablePrivacyRequestDto.class)
@JsonDeserialize(as = ImmutablePrivacyRequestDto.class)
public interface PrivacyRequestDto {
    static Builder builder() {
        return ImmutablePrivacyRequestDto.builder();
    }

    String phone();

    String email();

    long companyId();

    public interface Builder {
        Builder phone(String phone);

        Builder email(String email);

        Builder companyId(long companyId);

        PrivacyRequestDto build();
    }
}
