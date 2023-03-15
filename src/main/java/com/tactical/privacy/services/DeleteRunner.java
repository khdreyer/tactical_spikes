package com.tactical.privacy.services;

import com.tactical.privacy.DeleteOrchestrator;
import com.tactical.privacy.DeleteRequestTransformer;
import com.tactical.privacy.controller.PrivacyController;
import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.DeleteOrchestratorRequest;
import com.tactical.privacy.reporting.DeleteReportBuilder;
import com.tactical.privacy.repos.PrivacyRepository;
import com.tactical.privacy.stats.Logger;

public class DeleteRunner {
    private static final Logger LOG = Logger.getLogger(PrivacyController.class);
    private final DeleteOrchestrator deleteOrchestrator;
    private final DeleteRequestTransformer requestTransformer;
    private final DeleteReportBuilder reportBuilder;
    private final PrivacyRepository privacyRepository;

    public DeleteRunner(
        DeleteRequestTransformer requestTransformer,
        DeleteOrchestrator deleteOrchestrator,
        DeleteReportBuilder reportBuilder,
        PrivacyRepository privacyRepository)
    {
        this.requestTransformer = requestTransformer;
        this.deleteOrchestrator = deleteOrchestrator;
        this.reportBuilder = reportBuilder;
        this.privacyRepository = privacyRepository;
    }

    public void run(PrivacyDeleteRequestDto requestDto) throws Exception {
        try {
            DeleteOrchestratorRequest orchestratorRequest = requestTransformer.transform(requestDto);
            var response = deleteOrchestrator.process(orchestratorRequest);
            var report = reportBuilder.map(requestDto.getRequestId(), response);
            privacyRepository.writeDeleteReport(report);
        } catch (Exception ex) {
            LOG.error("An error occurred in the the delete runner", ex);
            throw ex;
        }
    }
}
