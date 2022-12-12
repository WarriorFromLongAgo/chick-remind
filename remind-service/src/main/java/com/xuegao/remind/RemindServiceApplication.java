package com.xuegao.remind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class RemindServiceApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RemindServiceApplication.class);
        application.run(args);
    }

}
