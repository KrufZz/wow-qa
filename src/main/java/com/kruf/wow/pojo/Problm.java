package com.kruf.wow.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("problm")
public class Problm {
    private Integer id;
    private String question;
    private String answer;


}
