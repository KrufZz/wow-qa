package com.kruf.wow.controller;


import com.kruf.wow.mapper.OrderMapper;
import com.kruf.wow.pojo.Order;
import com.kruf.wow.result.UserResp;
import com.kruf.wow.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @CrossOrigin
    @PostMapping(value = "api/order")
    @ResponseBody
    public UserResp Order(@RequestBody OrderVo orderVo) {
        Order order=new Order();
        log.info("订单信息[{}]",orderVo);
        BeanUtils.copyProperties(orderVo,order);
        boolean flag= orderMapper.insert(order)>0;
        if (flag){
            log.info("添加订单成功");
        }
        return UserResp.success("成功");
    }
}
