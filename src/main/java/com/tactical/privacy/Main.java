package com.tactical.privacy;

import com.tactical.privacy.config.AppConfig;
import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.DeleteOrchestratorRequest;
import com.tactical.privacy.interfaces.DeleteOrchestratorResponse;
import com.tactical.privacy.stats.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        try {
            LOG.info("Starting...");
            var context = new AnnotationConfigApplicationContext(AppConfig.class);
            DeleteOrchestrator orchestrator = context.getBean(DeleteOrchestrator.class);

            PrivacyDeleteRequestDto endpointRequest = PrivacyDeleteRequestDto.builder()
                .companyId(5)
                .phone("555-555-5555")
                .email("aawesome@gmail.com")
                .build();

            DeleteRequestTransformer enricher = context.getBean(DeleteRequestTransformer.class);
            DeleteOrchestratorRequest orchestratorRequest = enricher.transform(endpointRequest);
            DeleteOrchestratorResponse response = orchestrator.process(orchestratorRequest);

            LOG.info("All done!");

        } catch (Exception ex){
            LOG.info("Something failed!");
            throw ex;
        }
    }
}