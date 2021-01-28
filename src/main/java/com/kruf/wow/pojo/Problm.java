package com.kruf.wow.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("problm")
public class Problm {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String question;
    private String answer;


}
