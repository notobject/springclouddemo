package com.notobject.settings.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("demo-user-service")
public interface UserInfoService {
    @RequestMapping("/getUserInfo/{uid}")
    String getUserInfo(@PathVariable("uid") Long uid);
}
