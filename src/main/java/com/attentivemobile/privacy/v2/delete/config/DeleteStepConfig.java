package com.attentivemobile.privacy.v2.delete.config;

import com.attentivemobile.privacy.v2.delete.steps.IdentityUserDeleteStep;
import com.attentivemobile.privacy.v2.delete.steps.interfaces.DeleteStep;
import com.attentivemobile.privacy.v2.delete.steps.SubscriberMainMySqlDeleteStep;
import com.attentivemobile.privacy.v2.delete.steps.ThirdPartyCustomerDeleteStep;
import com.attentivemobile.privacy.v2.delete.steps.utils.DeleteStepCommonResponseBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DeleteStepConfig {

    @Bean
    @Scope(value = "prototype")
    public DeleteStep getSubscriberMainMySqlDeleteStep() {
        return new SubscriberMainMySqlDeleteStep(getCommonResponseBuilder());
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteStep getThirdPartyCustomerDeleteStep() {
        return new ThirdPartyCustomerDeleteStep(getCommonResponseBuilder());
    }

    @Bean
    @Scope(value = "prototype")
    public DeleteStep getIdentityUserDeleteStep() {
        return new IdentityUserDeleteStep(getCommonResponseBuilder());
    }

    @Bean
    public DeleteStepCommonResponseBuilder getCommonResponseBuilder() {
        return new DeleteStepCommonResponseBuilder();
    }
}