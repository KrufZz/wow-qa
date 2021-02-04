package com.kruf.wow.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kruf.wow.mapper.ProblmMapper;
import com.kruf.wow.mapper.UserMapper;
import com.kruf.wow.pojo.Problm;
import com.kruf.wow.pojo.User;
import com.kruf.wow.service.IProblmService;
import com.kruf.wow.vo.ProblmVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kruf
 * @since 2021-01-12
 */
@Service
@Slf4j
public class ProblmServiceImpl extends ServiceImpl<ProblmMapper, Problm> implements IProblmService {
    @Autowired
    private ProblmMapper problmMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Problm> issue(ProblmVo problmVo) {
        log.info("问题:{},姓名:{}",problmVo.getQuestion(),problmVo.getUsername());
        QueryWrapper<Problm> wrapper =new QueryWrapper<>();
        wrapper.like("question",problmVo.getQuestion());
        List<Problm> problms = problmMapper.selectList(wrapper);
        User user=null;
        if (!CollectionUtils.isEmpty(problms)){
            //不为空就加一次提问次数
            QueryWrapper<User> wrapperUser =new QueryWrapper<>();
            wrapperUser.eq("username",problmVo.getUsername());
            user = userMapper.selectOne(wrapperUser);
            Integer addNumber = userMapper.updateNumber(user.getId());
            if (addNumber>0){
                log.info("增加次数成功");
            }
        }
        return problms;
    }
}
