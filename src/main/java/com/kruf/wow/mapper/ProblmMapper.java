package com.kruf.wow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kruf.wow.pojo.Problm;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProblmMapper extends BaseMapper<Problm> {
    @Select("SELECT * FROM problm ORDER BY RAND() LIMIT 1 ")
    List<Problm> randomIssue(@Param("question")String question);
    
}
