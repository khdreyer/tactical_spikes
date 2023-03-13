package com.tactical.privacy.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutablePrivacyDeleteRequestDto.class)
@JsonDeserialize(as = ImmutablePrivacyDeleteRequestDto.class)
public interface PrivacyDeleteRequestDto {
    static Builder builder() {
        return ImmutablePrivacyDeleteRequestDto.builder();
    }

    long getCompanyId();

    String getPhone();

    String getEmail();


    interface Builder {
        Builder companyId(long companyId);

        Builder phone(String phone);

        Builder email(String email);

        PrivacyDeleteRequestDto build();
    }
}