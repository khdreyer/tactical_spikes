package com.tactical.privacy.repos;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.OrchestratorResponse;
import com.tactical.privacy.stats.Logger;

public class MockPrivacyRepository implements PrivacyRepository {
    private static final Logger LOG = Logger.getLogger(MockPrivacyRepository.class);

    @Override
    public void writeDeleteRequest(PrivacyDeleteRequestDto request) {
        LOG.info("Writing request to database...");
    }

    @Override
    public void writeDeleteResult(OrchestratorResponse result) {
        LOG.info("Writing delete result to run history table...");
    }
}