package com.notobject.userservice.api;

import com.notobject.userservice.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RefreshScope
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/getUserInfo/{uid}")
    public UserInfo getUserInfo(@PathVariable("uid") Long uid) {
        log.info("Access getUserInfo from " + uid);

        UserInfo ui = new UserInfo();
        ui.setId(uid);
        ui.setName("User-" + uid);
        ui.setAge(new Random(System.currentTimeMillis()).nextInt(100));

        return ui;
    }
}
