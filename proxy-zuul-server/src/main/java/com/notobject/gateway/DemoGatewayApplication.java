package com.notobject.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@RestController
@RefreshScope
public class DemoGatewayApplication {

    @Value("${version: unkown}")
    private String version;

    public static void main(String[] args) {

        SpringApplication.run(DemoGatewayApplication.class, args);
    }

    @RequestMapping("/version")
    public String version() {
        return "config version: " + version;
    }
}
