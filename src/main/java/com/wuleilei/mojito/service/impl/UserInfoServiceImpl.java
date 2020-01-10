package com.wuleilei.mojito.service.impl;

import com.wuleilei.mojito.entity.UserInfo;
import com.wuleilei.mojito.mapper.UserInfoMapper;
import com.wuleilei.mojito.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuleilei
 * @since 2020-01-08
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
