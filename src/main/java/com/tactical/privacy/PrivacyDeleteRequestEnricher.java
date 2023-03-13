package com.tactical.privacy;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.OrchestratorRequest;
import com.tactical.privacy.stats.Logger;

public class PrivacyDeleteRequestEnricher {

    private static final Logger LOG = Logger.getLogger(PrivacyDeleteRequestEnricher.class);

    public OrchestratorRequest transform(PrivacyDeleteRequestDto request) {
        try {
            return enrichAndBuildRequest(request.getCompanyId(), request.getPhone(), request.getEmail());
        } catch (Exception ex) {
            LOG.error("Failed to get additional identities from the Identity service.", ex);
            throw ex;
        }
    }

    private OrchestratorRequest enrichAndBuildRequest(long companyId, String phone, String email) {
        // TODO: call identity and get the subscriber
        //  and visitor ids to enrich the request for the orchestrator.

        var fakeSubId = 12345667L;
        var fakeVisitorId = "VSASDSIASSD_ASDS";

        return OrchestratorRequest.builder()
            .email(email)
            .phone(phone)
            .companyId(companyId)
            .visitorId(fakeVisitorId)
            .subscriberId(fakeSubId)
            .build();
    }
}
