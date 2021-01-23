package com.kruf.wow.mapper;

import org.apache.ibatis.annotations.Select;

public interface CronMapper {
    @Select("select cron from socks limit 1")
    String getCron();
}
