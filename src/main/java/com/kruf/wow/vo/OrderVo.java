package com.kruf.wow.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description= "返回的订单对象")
public class OrderVo {

    @ApiModelProperty(value = "业务名")
    String name;
    @ApiModelProperty(value = "子账号")
    String account;
    @ApiModelProperty(value = "角色名")
    String roleName;
    @ApiModelProperty(value = "装等")
    Integer grade;
    @ApiModelProperty(value = "手机号")
    String phone;
    @ApiModelProperty(value = "战网名")
    String battle;

}
