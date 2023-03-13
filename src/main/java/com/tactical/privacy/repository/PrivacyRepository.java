package com.tactical.privacy.repository;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;

public interface PrivacyRepository {
    void writeDeleteRequest(PrivacyDeleteRequestDto request);
    void writeDeleteResult();
}

