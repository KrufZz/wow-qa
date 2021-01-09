package com.kruf.wow.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResp {
    private Integer code;
    private Object data;

    public UserResp() {
    }

    public static UserResp success(Object data){
        UserResp resultVo = new UserResp();
        resultVo.setData(data);
        return resultVo;
    }

}
