package com.kruf.wow.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author kruf
 * @since 2021-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("wow_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    @ApiModelProperty("角色名")
    @TableField("role_name")
    private String roleName;

    /**
     * 业务名称
     */
    private String name;
    /**
     * 子账号
     */
    private String account;

    /**
     * 装等
     */
    private Integer grade;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 战网账号
     */
    private String battle;


}
