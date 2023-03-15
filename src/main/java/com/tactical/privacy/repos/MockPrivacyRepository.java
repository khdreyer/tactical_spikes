package com.tactical.privacy.repos;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.helpers.ObjectSerializer;
import com.tactical.privacy.reporting.DeleteReport;
import com.tactical.privacy.stats.Logger;

public class MockPrivacyRepository implements PrivacyRepository {
    private final ObjectSerializer serializer;
    public MockPrivacyRepository(ObjectSerializer serializer){
        this.serializer = serializer;
    }
    private static final Logger LOG = Logger.getLogger(MockPrivacyRepository.class);

    @Override
    public void writeDeleteRequest(PrivacyDeleteRequestDto request) {
        LOG.info("Writing request to database...");
    }

    @Override
    public void writeDeleteReport(DeleteReport report) {
        LOG.info("Writing delete result to run history table...");
        LOG.info(serializer.toPrettyString(report));
    }
}