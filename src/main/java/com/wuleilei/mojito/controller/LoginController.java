package com.wuleilei.mojito.controller;

import com.wuleilei.mojito.service.WechatService;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private WechatService wechatService;

    @ApiModelProperty("获取用户openId")
    @PostMapping("getOpenId")
    public String getOpenId(String code) {
        return wechatService.getOpenId(code);
    }

    @ApiModelProperty("获取小程序全局唯一后台接口调用凭据")
    @PostMapping("getAccessToken")
    public String getAccessToken() {
        return wechatService.getAccessToken();
    }
}
