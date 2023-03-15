package com.attentivemobile.privacy.repos;

import com.attentivemobile.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.reporting.DeleteReport;

public interface PrivacyRepository {
    void writeDeleteRequest(PrivacyDeleteRequestDto request);
    void writeDeleteReport(DeleteReport report);
}