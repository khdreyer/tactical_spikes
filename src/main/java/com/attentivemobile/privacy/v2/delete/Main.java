package com.attentivemobile.privacy.v2.delete;

import com.attentivemobile.privacy.v2.delete.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.v2.delete.config.AppConfig;
import com.attentivemobile.privacy.v2.delete.orchestrator.DeleteRunner;
import com.attentivemobile.privacy.v2.delete.stats.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            LOG.info("Starting...");

            var appConfig = new AppConfig();
            var context = appConfig.getApplicationContext();

            DeleteRunner runner = context.getBean(DeleteRunner.class);

            PrivacyDeleteRequestDto endpointRequest = PrivacyDeleteRequestDto.builder()
                .requestId(1)
                .companyId(5)
                .phone("555-555-5555")
                .email("aawesome@gmail.com")
                .build();

            runner.run(endpointRequest);

            LOG.info("All done!");

        } catch (Exception ex){
            LOG.info("Something failed!");
            throw ex;
        }
    }
}