package com.smartworkflow.genericcrudapp.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate konfigürasyonu
 * Gelecekteki dış API entegrasyonları için hazırlanmıştır
 */
@Configuration
public class ClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
