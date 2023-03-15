package com.tactical.privacy.repos;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.reporting.DeleteReport;

public interface PrivacyRepository {
    void writeDeleteRequest(PrivacyDeleteRequestDto request);
    void writeDeleteReport(DeleteReport report);
}