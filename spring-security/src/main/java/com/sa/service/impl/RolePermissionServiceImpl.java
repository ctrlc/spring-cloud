package com.sa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sa.domain.RolePermission;
import com.sa.mapper.RolePermissionMapper;
import com.sa.service.RolePermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author sa
 * @date 2020-04-17
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

}