package com.tactical.privacy;

import com.tactical.privacy.config.AppConfig;
import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.Orchestrator;
import com.tactical.privacy.stats.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            LOG.info("Starting...");
            var context = new AnnotationConfigApplicationContext(AppConfig.class);
            var orchestrator = context.getBean(Orchestrator.class);

            var endpointRequest = PrivacyDeleteRequestDto.builder()
                .companyId(5)
                .phone("555-555-5555")
                .email("aawesome@gmail.com")
                .build();

            var enricher = context.getBean(PrivacyDeleteRequestEnricher.class);
            var orchestratorRequest = enricher.transform(endpointRequest);
            var response = orchestrator.process(orchestratorRequest);

            LOG.info("All done!");

        } catch (Exception ex){
            LOG.info("Something failed!");
            throw ex;
        }
    }
}