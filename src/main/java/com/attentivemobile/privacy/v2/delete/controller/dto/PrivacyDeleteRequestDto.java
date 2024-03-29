package com.attentivemobile.privacy.v2.delete.controller.dto;

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

    int getRequestId();

    long getCompanyId();

    String getPhone();

    String getEmail();

    @Value.Default
    default String[] getStepsFilter()  {
        return new String[] {};
    }

    interface Builder {

        Builder requestId(int requestId);

        Builder companyId(long companyId);

        Builder phone(String phone);

        Builder email(String email);

        Builder stepsFilter(String[] stepsFilter);

        PrivacyDeleteRequestDto build();
    }
}