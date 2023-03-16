package com.attentivemobile.privacy.v2.delete.config;

import com.attentivemobile.privacy.v2.delete.helpers.ObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public ObjectSerializer getSerializer(){
        return new ObjectSerializer();
    }

}