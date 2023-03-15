package com.tactical.privacy.config;

import com.tactical.privacy.helpers.ObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public ObjectSerializer getSerializer(){
        return new ObjectSerializer();
    }

}