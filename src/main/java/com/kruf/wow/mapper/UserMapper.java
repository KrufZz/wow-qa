package com.kruf.wow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kruf.wow.pojo.User;
import org.apache.ibatis.annotations.Update;

public interface UserMapper extends BaseMapper<User> {

    User getByUsernameAndPasswrod(User user);

    @Update("update user set number=number+1 where id=${id}")
    Integer updateNumber(Integer id);

}
