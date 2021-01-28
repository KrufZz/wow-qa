package com.kruf.wow.controller;


import com.kruf.wow.pojo.User;
import com.kruf.wow.result.UserResp;
import com.kruf.wow.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


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
