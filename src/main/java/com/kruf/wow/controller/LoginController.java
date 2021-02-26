package com.kruf.wow.controller;


import com.kruf.wow.annotation.LimitRequest;
import com.kruf.wow.pojo.User;
import com.kruf.wow.result.ResultVo;
import com.kruf.wow.result.UserResp;
import com.kruf.wow.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @CrossOrigin
    @GetMapping(value = "api/test")
    @ResponseBody
    @LimitRequest(count = 1)
    public ResultVo test(){
        ResultVo vo=new ResultVo();
        vo.setCode(200);
        vo.setData("阿伟!");
        vo.setMsg("返回成功");
        return vo;
    }
}
