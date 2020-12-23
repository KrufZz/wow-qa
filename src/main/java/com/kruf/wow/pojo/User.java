package com.kruf.wow.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer number;
    private String realname;
}
