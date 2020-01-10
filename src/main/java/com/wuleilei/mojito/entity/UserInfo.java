package com.wuleilei.mojito.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuleilei
 * @since 2020-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserInfo对象", description="用户信息")
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String account;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "加密盐")
    private String salt;

    @ApiModelProperty(value = "用户注册时间")
    private LocalDateTime registerTime;

    @ApiModelProperty(value = "用户状态")
    private Integer state;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "1手机验证通过")
    private Integer phoneCheck;

    @ApiModelProperty(value = "1邮箱验证通过")
    private Integer emailCheck;

    @ApiModelProperty(value = "用户登录IP")
    private String ip;

    @ApiModelProperty(value = "发送验证码时间")
    private LocalDateTime codesendDate;

    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    @ApiModelProperty(value = "随机验证码")
    private String verificationCode;

    @ApiModelProperty(value = "小程序ID")
    private String openId;


}
