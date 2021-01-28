package com.kruf.wow.controller;

import com.kruf.wow.mapper.UserMapper;
import com.kruf.wow.pojo.User;
import com.kruf.wow.result.Result;
import com.kruf.wow.result.UserResp;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class RegisterController {

    @Autowired
    private UserMapper userMapper;

    public static final String USER_EXIST = "用户名已被使用";
    public static final String PASSWORD_SHORT = "密码不能少于三位";


    @CrossOrigin
    @PostMapping("api/register")
    @ResponseBody
    public UserResp register(@RequestBody User user) throws Exception {
        UserResp userResp = new UserResp();
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        Boolean exist = userMapper.isExist(username) > 0;
        if (exist) {
            userResp.setCode(Result.ERROR.getCode());
            userResp.setData(USER_EXIST);
            return userResp;
        }

        if (user.getPassword().length() < 3) {
            userResp.setCode(Result.ERROR.getCode());
            userResp.setData(PASSWORD_SHORT);
            return userResp;
        }


        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userMapper.insert(user);
        userResp.setCode(Result.SUCCESS.getCode());


        return userResp;
    }
}
