package com.kruf.wow.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Result {
    SUCCESS(200,"响应成功"),
    ERROR(400,"响应失败");


   private int code;
   private String msg;


}
