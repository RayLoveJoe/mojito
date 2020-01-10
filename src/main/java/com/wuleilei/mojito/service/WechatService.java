package com.wuleilei.mojito.service;

public interface WechatService {
    /**
     * 通过获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程
     * @param code
     * @return
     */
    String getOpenId(String code);

    /**
     * 获取小程序全局唯一后台接口调用凭据（access_token）
     * @return
     */
    String getAccessToken();
}
