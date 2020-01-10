package com.wuleilei.mojito.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wuleilei.mojito.config.WechatConfig;
import com.wuleilei.mojito.service.WechatService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class WechatServiceImpl implements WechatService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WechatServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?grant_type={grant_type}&appid={appid}&secret={secret}&js_code={js_code}";
        Map<String, Object> params = new HashMap<>();

        params.put("grant_type", "authorization_code");
        params.put("appid", wechatConfig.getAppId());
        params.put("secret", wechatConfig.getSecret());
        params.put("js_code", code);

        // 请求获取返回结果
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, params);
        String resultJson = responseEntity.getBody();
        LOGGER.info("小程序获取用户唯一标识,result:{}",resultJson);
        JSONObject jsonObject = JSON.parseObject(resultJson);
        return jsonObject.getString("openid");
    }

    @Override
    public String getAccessToken() {
        // 先从Redis中获取access_token，缓存失效再请求微信获取
        String accessToken = stringRedisTemplate.opsForValue().get("access_token");
        if (StringUtils.isBlank(accessToken)) {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type={grant_type}&appid={appid}&secret={secret}";
            Map<String, Object> params = new HashMap<>();

            params.put("grant_type", "client_credential");
            params.put("appid", wechatConfig.getAppId());
            params.put("secret", wechatConfig.getSecret());

            // 请求获取返回结果
            JSONObject jsonObject = restTemplate.getForObject(url, JSONObject.class, params);
            LOGGER.info("获取小程序全局唯一后台接口调用凭据(access_token),Result:{}",jsonObject.toJSONString());
            accessToken = jsonObject.getString("access_token");
            // 缓存到Redis中
            stringRedisTemplate.opsForValue().set("access_token",accessToken,30, TimeUnit.MINUTES);
        }
        return accessToken;
    }
}
