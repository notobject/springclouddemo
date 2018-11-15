package com.notobject.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RefreshController {

    @Value("${version: \"undefined\"}")
    private String version;

    @RequestMapping("/check")
    public String check() {
        return version;
    }
}
