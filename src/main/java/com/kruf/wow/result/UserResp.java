package com.kruf.wow.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResp {
    private Integer code;
    private String realname;
    private Integer number;

}
