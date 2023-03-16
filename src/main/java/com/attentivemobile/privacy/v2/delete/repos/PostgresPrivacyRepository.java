package com.attentivemobile.privacy.v2.delete.repos;

import com.attentivemobile.privacy.v2.delete.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.v2.delete.helpers.ObjectSerializer;
import com.attentivemobile.privacy.v2.delete.reporting.DeleteReport;
import com.attentivemobile.privacy.v2.delete.stats.Logger;
import org.apache.commons.lang3.NotImplementedException;

public class PostgresPrivacyRepository implements PrivacyRepository {
    private static final Logger LOG = Logger.getLogger(PostgresPrivacyRepository.class);

    private final ObjectSerializer serializer;

    public PostgresPrivacyRepository(ObjectSerializer serializer){
        this.serializer = serializer;
    }

    @Override
    public void writeDeleteRequest(PrivacyDeleteRequestDto request) {
        var ex = new NotImplementedException();
        LOG.error("This function is not implemented!", ex);
        throw ex;
    }

    @Override
    public void writeDeleteReport(DeleteReport report) {
        LOG.info(serializer.toPrettyString(report));
        var ex = new NotImplementedException();
        LOG.error("This function is not implemented!", ex);
        throw ex;
    }
}
