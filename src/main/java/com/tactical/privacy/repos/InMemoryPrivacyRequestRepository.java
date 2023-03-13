package com.tactical.privacy.repos;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPrivacyRequestRepository {
    List<PrivacyDeleteRequestDto> privacyRequestDtoList = new ArrayList<>();

    public void pushRequest(PrivacyDeleteRequestDto request) {
        privacyRequestDtoList.add(request);
    }
}
