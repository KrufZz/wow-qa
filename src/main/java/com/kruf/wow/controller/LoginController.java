package com.kruf.wow.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kruf.wow.mapper.UserMapper;
import com.kruf.wow.pojo.User;
import com.kruf.wow.result.Result;
import com.kruf.wow.result.UserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;



@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;


    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public UserResp login(@RequestBody User user) {
        System.out.println(user.toString());
        System.out.println(user.getUsername());
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);

        QueryWrapper<User>  wrapper =new QueryWrapper<>();
        wrapper.eq("username",username);
        wrapper.eq("password",user.getPassword());
        User loginUser = userMapper.selectOne(wrapper);

        if (loginUser !=null){
            return new UserResp(Result.SUCCESS.getCode(),username,loginUser.getNumber());
        }else {
            return new UserResp(Result.ERROR.getCode(),username,loginUser.getNumber());
        }
    }
}
