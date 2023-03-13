package com.tactical.privacy;

import com.tactical.privacy.config.AppConfig;
import com.tactical.privacy.interfaces.Orchestrator;
import com.tactical.privacy.interfaces.OrchestratorRequest;
import com.tactical.privacy.stats.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            LOG.info("Starting...");
            var context = new AnnotationConfigApplicationContext(AppConfig.class);
            var orchestrator = context.getBean(Orchestrator.class);

            var sampleRequest
                = OrchestratorRequest.builder()
                    .companyId(5)
                    .phone("555-555-5555")
                    .email("aawesome@gmail.com")
                    .visitorId("SOMEFAKEVISITORID")
                    .subscriberId(123456L)
                    .build();

            var response = orchestrator.process(sampleRequest);
        } catch (Exception ex){
            LOG.info("Something failed!");
            throw ex;
        }
    }
}