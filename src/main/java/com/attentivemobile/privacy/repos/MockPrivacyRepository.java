package com.attentivemobile.privacy.repos;

import com.attentivemobile.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.stats.Logger;
import com.attentivemobile.privacy.helpers.ObjectSerializer;
import com.attentivemobile.privacy.reporting.DeleteReport;

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