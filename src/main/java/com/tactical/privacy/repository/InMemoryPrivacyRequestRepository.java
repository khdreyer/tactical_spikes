package com.tactical.privacy.repository;

import com.tactical.privacy.dto.PrivacyRequestDto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPrivacyRequestRepository {
    List<PrivacyRequestDto> privacyRequestDtoList = new ArrayList<>();

    public void pushRequest(PrivacyRequestDto privacyRequestDto) {
        privacyRequestDtoList.add(privacyRequestDto);
    }
}
