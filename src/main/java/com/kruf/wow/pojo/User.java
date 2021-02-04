package com.kruf.wow.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    @NotNull(message = "用户密码不能为空")
    @Size(min = 3, max = 11, message = "密码长度必须是3-16个字符")
    private String password;
    private Integer number;
    private String realname;
    private String salt;
}
