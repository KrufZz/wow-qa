package com.kruf.wow.controller;


import com.kruf.wow.mapper.ProblmMapper;
import com.kruf.wow.pojo.Problm;
import com.kruf.wow.service.IProblmService;
import com.kruf.wow.vo.ProblmVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class IssueController {
    @Autowired
    private IProblmService problmService;
    @Autowired
    private ProblmMapper problmMapper;


    @CrossOrigin
    @PostMapping(value = "api/issue")
    @ResponseBody
    public List<Problm> issue(@RequestBody ProblmVo problmVo) {
        List<Problm> issue = problmService.issue(problmVo);
        return issue;
    }


    @CrossOrigin
    @PostMapping(value = "api/randomissue")
    @ResponseBody
    public List<Problm> randomIssue(@RequestBody Problm problm) {
        List<Problm> problms = null;
        return problms;
    }



    @PostMapping(value = "/list")
    @ResponseBody
    public List<Problm> get(String id) {
        List<Problm> problms = problmMapper.get(id);
        return problms;
    }
}
