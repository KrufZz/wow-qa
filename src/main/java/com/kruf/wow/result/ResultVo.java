package com.kruf.wow.result;

import lombok.Data;

@Data
public class ResultVo<T> {
    /**
     * 响应码
     */
    private int code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;


}
