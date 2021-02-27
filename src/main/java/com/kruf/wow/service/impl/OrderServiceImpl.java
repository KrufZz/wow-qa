package com.kruf.wow.service.impl;

import com.kruf.wow.pojo.Order;
import com.kruf.wow.mapper.OrderMapper;
import com.kruf.wow.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kruf
 * @since 2021-02-27
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
