package com.kruf.wow.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.kruf.wow.pojo.Problm;
import com.kruf.wow.vo.ProblmVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kruf
 * @since 2021-01-12
 */
public interface IProblmService extends IService<Problm> {
    List<Problm> issue(ProblmVo problmVo);
}
