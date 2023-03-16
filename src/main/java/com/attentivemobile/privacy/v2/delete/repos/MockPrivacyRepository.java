package com.attentivemobile.privacy.v2.delete.repos;

import com.attentivemobile.privacy.v2.delete.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.v2.delete.stats.Logger;
import com.attentivemobile.privacy.v2.delete.helpers.ObjectSerializer;
import com.attentivemobile.privacy.v2.delete.reporting.DeleteReport;

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