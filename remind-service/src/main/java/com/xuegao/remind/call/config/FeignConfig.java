package com.xuegao.remind.call.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    @ConditionalOnMissingBean
    public Retryer feignRetry() {
        //代表永远不重试
        return new Retryer.Default();
    }

}
