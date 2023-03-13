package com.tactical.privacy.repository;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.stats.Logger;

public class MockPrivacyRepository implements PrivacyRepository {
    private static final Logger LOG = Logger.getLogger(MockPrivacyRepository.class);

    @Override
    public void writeDeleteRequest(PrivacyDeleteRequestDto request) {
        LOG.info("Writing request to database...");
    }

    @Override
    public void writeDeleteResult() {
        LOG.info("Writing delete result to run history table...");
    }
}