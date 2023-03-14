package com.tactical.privacy;

import com.tactical.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.tactical.privacy.interfaces.DeleteOrchestratorRequest;
import com.tactical.privacy.interfaces.UserIdentities;
import com.tactical.privacy.stats.Logger;
import com.tactical.privacy.steps.utils.DeleteStepConvertor;

public class DeleteRequestTransformer {

    private static final Logger LOG = Logger.getLogger(DeleteRequestTransformer.class);

    DeleteStepConvertor stepConvertor;

    public DeleteRequestTransformer(DeleteStepConvertor stepConvertor){
        this.stepConvertor = stepConvertor;
    }

    public DeleteOrchestratorRequest transform(PrivacyDeleteRequestDto request) {
        try {
            DeleteOrchestratorRequest.Builder builder = DeleteOrchestratorRequest.builder();
            builder.companyId(request.getCompanyId());
            addStepFilter(builder, request.getStepsFilter());
            addIdentities(builder, request.getCompanyId(), request.getPhone(), request.getEmail());
            return builder.build();
        } catch (Exception ex) {
            LOG.error("Failed to transform api request into a delete orchestrator request!", ex);
            throw ex;
        }
    }

    private void addStepFilter(
        DeleteOrchestratorRequest.Builder builder,
        String[] stepsFilter)
    {
        var convertedSteps = stepConvertor.tryConvert(stepsFilter);
        builder.stepFilter(convertedSteps);
    }

    private void addIdentities(
        DeleteOrchestratorRequest.Builder builder,
        long companyId,
        String phone,
        String email)
    {
        var userIdentities = getIdentities(companyId, phone, email);
        builder.userIdentities(userIdentities);
    }

    private UserIdentities getIdentities(
        long companyId,
        String phone,
        String email) {

        // TODO: call identity and get the subscriber
        //  and visitor ids to enrich the request for the orchestrator

        // call a user identity service - separate class to be injected.

        long fakeSubId = 12345667L;
        String fakeVisitorId = "VSASDSIASSD_ASDS";

        UserIdentities userIdentities = UserIdentities.builder()
            .email(email)
            .phone(phone)
            .visitorId(fakeVisitorId)
            .subscriberId(fakeSubId)
            .build();

        return userIdentities;
    }
}