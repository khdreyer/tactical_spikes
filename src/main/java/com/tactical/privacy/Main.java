package com.tactical.privacy;

import com.tactical.privacy.services.ServiceRunner;
import com.tactical.privacy.stats.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Starting...!");

        var runner = new ServiceRunner();
        runner.start();
    }
}