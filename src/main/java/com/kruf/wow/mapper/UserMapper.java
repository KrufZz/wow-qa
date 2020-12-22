package com.kruf.wow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kruf.wow.pojo.User;

public interface UserMapper extends BaseMapper<User> {

    User getByUsernameAndPasswrod(User user);

}
