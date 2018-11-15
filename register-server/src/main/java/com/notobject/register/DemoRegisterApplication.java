package com.notobject.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoRegisterApplication.class, args);
    }
}
