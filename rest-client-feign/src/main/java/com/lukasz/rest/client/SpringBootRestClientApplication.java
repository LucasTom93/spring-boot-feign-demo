package com.lukasz.rest.client;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
class SpringBootRestClientApplication {

    public static void main(String[] args) {
        SpringApplication apiApplication = new SpringApplication(SpringBootRestClientApplication.class);
        apiApplication.setBannerMode(Banner.Mode.OFF);
        apiApplication.run(args);
    }
}
