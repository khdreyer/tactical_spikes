package com.attentivemobile.privacy.config;

import com.attentivemobile.privacy.helpers.ObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public ObjectSerializer getSerializer(){
        return new ObjectSerializer();
    }

}