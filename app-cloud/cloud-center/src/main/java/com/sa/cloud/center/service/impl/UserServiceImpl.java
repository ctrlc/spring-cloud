package com.sa.cloud.center.service.impl;


import com.sa.cloud.base.domain.center.User;
import com.sa.cloud.center.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<User> listUser(User user) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }
}
