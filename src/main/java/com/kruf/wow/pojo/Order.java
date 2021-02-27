package com.kruf.wow.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId("role_name")
    private String roleName;

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
