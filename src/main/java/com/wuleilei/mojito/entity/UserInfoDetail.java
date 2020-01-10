package com.wuleilei.mojito.entity;

import java.time.LocalDate;
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
@ApiModel(value="UserInfoDetail对象", description="用户详细信息")
public class UserInfoDetail implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户id关联user_info表的（id）")
    private Integer userId;

    @ApiModelProperty(value = "用户真实名称")
    private String realName;

    @ApiModelProperty(value = "用户地址")
    private String address;

    @ApiModelProperty(value = "用户头像图标地址")
    private String icon;

    @ApiModelProperty(value = "用户性别(0.未知、1.男、2.女)")
    private Integer sex;

    @ApiModelProperty(value = "用户出生年月日")
    private LocalDate birthday;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "省")
    private Integer province;

    @ApiModelProperty(value = "城市")
    private Integer city;

    @ApiModelProperty(value = "区")
    private Integer district;

    @ApiModelProperty(value = "街道")
    private Integer street;


}
