package com.tactical.privacy.services;

import com.tactical.privacy.stats.Logger;

public class ServiceRunner {
    private static final Logger LOG = Logger.getLogger(ServiceRunner.class);

    public ServiceRunner(){

    }

    public void start(){
        LOG.info("Starting service runner.");
    }
}