package com.example.hanyan.hanee.service;

import com.example.hanyan.hanee.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vigo
 * @since 2021-04-07
 */
public interface IUserService extends IService<User> {

    /**
     * 查询用户信息
     * @param username 用户名
     * @return 用户实体
    */
    User findUserById(String username);

    /**
     * 新增用户信息
     * @param userInfo 用户信息
     * @return 用户实体
     */
    User saveUserInfo(User userInfo);
}
