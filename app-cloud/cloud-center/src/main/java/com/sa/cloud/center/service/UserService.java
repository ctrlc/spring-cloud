package com.sa.cloud.center.service;


import com.sa.cloud.base.domain.center.User;

import java.util.List;

public interface UserService {

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    List<User> listUser(User user);

    /**
     * 添加
     *
     * @param user
     */
    int addUser(User user);

    /**
     * 修改
     *
     * @param user
     */
    int updateUser(User user);
}
