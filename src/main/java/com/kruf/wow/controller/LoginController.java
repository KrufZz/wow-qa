package com.kruf.wow.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kruf.wow.mapper.UserMapper;
import com.kruf.wow.pojo.User;
import com.kruf.wow.result.Result;
import com.kruf.wow.result.UserResp;
import com.kruf.wow.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;


@Controller
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;


    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public UserResp login(@RequestBody User user) {
        log.info("进入请求");
        UserResp userResp = userService.loginUser(user);
        return userResp;
    }

    @ResponseBody
    @PostMapping("/test")
    public String test(){
        return "hello";
    }
}
