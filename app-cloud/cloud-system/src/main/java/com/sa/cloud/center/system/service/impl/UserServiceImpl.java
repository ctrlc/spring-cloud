package com.sa.cloud.center.system.service.impl;

import com.sa.cloud.center.system.domain.User;
import com.sa.cloud.center.system.mapper.UserMapper;
import com.sa.cloud.center.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sa
 * @since 2020-04-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
