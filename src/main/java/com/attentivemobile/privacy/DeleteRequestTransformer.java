package com.attentivemobile.privacy;

import com.attentivemobile.privacy.controller.dto.PrivacyDeleteRequestDto;
import com.attentivemobile.privacy.interfaces.DeleteOrchestratorRequest;
import com.attentivemobile.privacy.interfaces.UserIdentities;
import com.attentivemobile.privacy.services.IdentityService;
import com.attentivemobile.privacy.services.IdentityServiceRequest;
import com.attentivemobile.privacy.stats.Logger;
import com.attentivemobile.privacy.steps.utils.DeleteStepConvertor;

public class DeleteRequestTransformer {

    private static final Logger LOG = Logger.getLogger(DeleteRequestTransformer.class);

    DeleteStepConvertor stepConvertor;
    IdentityService identityService;

    public DeleteRequestTransformer(
        DeleteStepConvertor stepConvertor,
        IdentityService identityService){
        this.stepConvertor = stepConvertor;
        this.identityService = identityService;
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

        var identityRequest = IdentityServiceRequest.builder()
            .companyId(companyId)
            .phone(phone)
            .email(email)
            .build();

        var identityResponse = identityService.fetch(identityRequest);

        UserIdentities userIdentities = UserIdentities.builder()
            .email(email)
            .phone(phone)
            .visitorId(identityResponse.getVisitorId())
            .subscriberId(identityResponse.getSubscriberId())
            .build();

        return userIdentities;
    }
}