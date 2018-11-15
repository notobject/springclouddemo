package com.notobject.settings.api;

import com.notobject.settings.entity.SettingsInfo;
import com.notobject.settings.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RefreshScope
public class SettingsController {

    private static final Logger log = LoggerFactory.getLogger(SettingsController.class);

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/getSettings/{uid}")
    public List<SettingsInfo> getSettings(@PathVariable("uid") Long uid) {
        String userInfo = userInfoService.getUserInfo(uid);
        log.info(userInfo);

        return new ArrayList<>();
    }
}
