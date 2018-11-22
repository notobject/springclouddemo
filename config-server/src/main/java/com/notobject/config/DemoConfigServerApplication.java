package com.notobject.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class DemoConfigServerApplication {
    public static void main(String[] args) {
        // docker run --name config-server -p 8888:8888 -t image/config-server --restart=always
        SpringApplication.run(DemoConfigServerApplication.class, args);
    }
}
