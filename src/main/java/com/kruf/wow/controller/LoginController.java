package com.kruf.wow.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kruf.wow.mapper.UserMapper;
import com.kruf.wow.pojo.User;
import com.kruf.wow.result.Result;
import com.kruf.wow.result.UserResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;



@Controller
@Slf4j
public class LoginController {
    @Autowired
    private UserMapper userMapper;


    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public UserResp login(@RequestBody User user) {
        String username = user.getUsername();
        Subject subject = SecurityUtils .getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, user.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return new UserResp(200,username);
        }catch (AuthenticationException e){
            String msg="账号密码错误";
            return new UserResp(400,msg);
        }


    }
}
