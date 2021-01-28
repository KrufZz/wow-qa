package com.kruf.wow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kruf.wow.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Update("update user set number=number+1 where id=${id}")
    Integer updateNumber(Integer id);

    List<User> testSql();

    Integer isExist(@Param("username") String username);

}
