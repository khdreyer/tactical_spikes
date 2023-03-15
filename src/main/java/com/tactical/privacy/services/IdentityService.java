package com.tactical.privacy.services;

import com.tactical.privacy.stats.Logger;

public class IdentityService {

    private static final Logger LOG = Logger.getLogger(IdentityService.class);

    public IdentityServiceResponse fetch(IdentityServiceRequest request) {

        // TODO: call identity and get the subscriber and visitor ids
        LOG.info("Not Implemented!");

        return IdentityServiceResponse.builder()
            .subscriberId(1234556L)
            .visitorId("anotherIdentifier")
            .build();
    }
}

