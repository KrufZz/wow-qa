package com.kruf.wow.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kruf.wow.mapper.ProblmMapper;
import com.kruf.wow.mapper.UserMapper;
import com.kruf.wow.pojo.Problm;
import com.kruf.wow.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class IssueController {
    @Autowired
    private ProblmMapper problmMapper;
    @Autowired
    private UserMapper userMapper;


    @CrossOrigin
    @PostMapping(value = "api/issue")
    @ResponseBody
    public List<Problm> issue(@RequestBody Problm problm){
        log.info("问题是:{}",problm.getQuestion());
        QueryWrapper<Problm> wrapper =new QueryWrapper<>();
        wrapper.like("question",problm.getQuestion());
        List<Problm> problms = problmMapper.selectList(wrapper);
        User user=null;
        Integer countNumber=0;
        if (!CollectionUtils.isEmpty(problms)){
            //不为空就加一次提问次数
            UpdateWrapper<User> upWrapper=new UpdateWrapper<>();
            user = userMapper.selectById(1);
            upWrapper.setSql("number = number +1 where id="+user.getId());
            int update = userMapper.update(user, upWrapper);
            if (update>0){
                log.info("增加次数成功");
            }
        }
        return problms;
    }


    @CrossOrigin
    @PostMapping(value = "api/randomissue")
    @ResponseBody
    public List<Problm> randomIssue(@RequestBody Problm problm){
        List<Problm> problms = problmMapper.randomIssue(problm.getQuestion());
        return problms;
    }
}
