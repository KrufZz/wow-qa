package com.kruf.wow.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.kruf.wow.pojo.User;
import com.kruf.wow.result.UserResp;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kruf
 * @since 2021-01-11
 */
public interface IUserService extends IService<User> {
    /**
     *
     * @param user
     * @return 响应码以及用户名
     */
    UserResp loginUser(User user);
}
