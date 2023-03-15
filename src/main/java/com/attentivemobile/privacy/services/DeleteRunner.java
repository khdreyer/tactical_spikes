package com.attentivemobile.privacy.services;

import com.attentivemobile.privacy.DeleteOrchestrator;
import com.attentivemobile.privacy.DeleteRequestTransformer;
import com.attentivemobile.privacy.controller.PrivacyController;
import com.attentivemobile.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.interfaces.DeleteOrchestratorRequest;
import com.attentivemobile.privacy.reporting.DeleteReportBuilder;
import com.attentivemobile.privacy.repos.PrivacyRepository;
import com.attentivemobile.privacy.stats.Logger;

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

    public void run(PrivacyDeleteRequestDto requestDto) {
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
