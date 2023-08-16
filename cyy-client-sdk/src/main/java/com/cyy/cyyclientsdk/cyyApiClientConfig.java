package com.cyy.cyyclientsdk;

import com.cyy.cyyclientsdk.client.cyyClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("cyyapi.client") //读取application.properties
@Data
@ComponentScan
public class cyyApiClientConfig {
    private String accessKey;
    private String secretKey;
    @Bean
    public cyyClient cyyCl(){
        return new cyyClient(accessKey, secretKey);
    }
}
