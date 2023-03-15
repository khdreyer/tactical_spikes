package com.tactical.privacy.config;

import com.tactical.privacy.interfaces.DeleteStep;
import com.tactical.privacy.steps.IdentityUserDeleteStep;
import com.tactical.privacy.steps.SubscriberMainMySqlDeleteStep;
import com.tactical.privacy.steps.ThirdPartyCustomerDeleteStep;
import com.tactical.privacy.steps.utils.DeleteStepCommonResponseBuilder;
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