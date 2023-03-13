package com.tactical.privacy.repos;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.OrchestratorResponse;

public interface PrivacyRepository {
    void writeDeleteRequest(PrivacyDeleteRequestDto request);
    void writeDeleteResult(OrchestratorResponse result);
}