package com.notobject.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class DemoUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoUserServiceApplication.class, args);
    }
}
