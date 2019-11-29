package com.lukasz.rest.api;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class SpringBootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication clientApplication = new SpringApplication(SpringBootRestApiApplication.class);
        clientApplication.setBannerMode(Banner.Mode.OFF);
        clientApplication.run(args);
    }
}
