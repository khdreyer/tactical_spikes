package com.attentivemobile.privacy.v2.delete.repos;

import com.attentivemobile.privacy.v2.delete.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.v2.delete.reporting.DeleteReport;

public interface PrivacyRepository {
    void writeDeleteRequest(PrivacyDeleteRequestDto request);
    void writeDeleteReport(DeleteReport report);
}