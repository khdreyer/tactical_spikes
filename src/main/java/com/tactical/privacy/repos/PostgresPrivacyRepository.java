package com.tactical.privacy.repos;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.DeleteOrchestratorResponse;
import com.tactical.privacy.stats.Logger;
import org.apache.commons.lang3.NotImplementedException;

public class PostgresPrivacyRepository implements PrivacyRepository {
    private static final Logger LOG = Logger.getLogger(PostgresPrivacyRepository.class);

    @Override
    public void writeDeleteRequest(PrivacyDeleteRequestDto request) {
        var ex = new NotImplementedException();
        LOG.error("This function is not implemented!", ex);
        throw ex;
    }

    @Override
    public void writeDeleteResult(DeleteOrchestratorResponse result) {
        var ex = new NotImplementedException();
        LOG.error("This function is not implemented!", ex);
        throw ex;
    }
}
