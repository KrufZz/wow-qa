package com.kruf.wow.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kruf.wow.mapper.ProblmMapper;
import com.kruf.wow.mapper.UserMapper;
import com.kruf.wow.pojo.Problm;
import com.kruf.wow.pojo.User;
import com.kruf.wow.service.IProblmService;
import com.kruf.wow.vo.ProblmVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class IssueController {
    @Autowired
    private IProblmService problmService;


    @CrossOrigin
    @PostMapping(value = "api/issue")
    @ResponseBody
    public List<Problm> issue(@RequestBody ProblmVo problmVo){
        List<Problm> issue = problmService.issue(problmVo);
        return issue;
    }


    @CrossOrigin
    @PostMapping(value = "api/randomissue")
    @ResponseBody
    public List<Problm> randomIssue(@RequestBody Problm problm){
        List<Problm> problms = null;
        return problms;
    }
}
