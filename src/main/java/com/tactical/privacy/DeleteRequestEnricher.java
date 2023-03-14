package com.tactical.privacy;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.DeleteOrchestratorRequest;
import com.tactical.privacy.interfaces.UserIdentities;
import com.tactical.privacy.stats.Logger;

public class DeleteRequestEnricher {

    private static final Logger LOG = Logger.getLogger(DeleteRequestEnricher.class);

    public DeleteOrchestratorRequest transform(PrivacyDeleteRequestDto request) {
        try {
            return enrichAndBuildRequest(request.getCompanyId(), request.getPhone(), request.getEmail());
        } catch (Exception ex) {
            LOG.error("Failed to get additional identities from the Identity service.", ex);
            throw ex;
        }
    }

    private DeleteOrchestratorRequest enrichAndBuildRequest(long companyId, String phone, String email) {
        // TODO: call identity and get the subscriber
        //  and visitor ids to enrich the request for the orchestrator.

        long fakeSubId = 12345667L;
        String fakeVisitorId = "VSASDSIASSD_ASDS";

        UserIdentities userIdentities = UserIdentities.builder()
            .email(email)
            .phone(phone)
            .visitorId(fakeVisitorId)
            .subscriberId(fakeSubId)
            .build();

        return DeleteOrchestratorRequest.builder()
            .userIdentities(userIdentities)
            .companyId(companyId)
            .build();
    }
}