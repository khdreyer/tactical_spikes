package com.tactical.privacy;

import com.tactical.privacy.stats.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        LOG.info("Starting Application.");
        SpringApplication.run(Application.class, args);
    }
}