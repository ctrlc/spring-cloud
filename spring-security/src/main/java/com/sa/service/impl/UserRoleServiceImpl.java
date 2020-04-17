package com.sa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sa.domain.UserRole;
import com.sa.mapper.UserRoleMapper;
import com.sa.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author sa
 * @date 2020-04-17
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}