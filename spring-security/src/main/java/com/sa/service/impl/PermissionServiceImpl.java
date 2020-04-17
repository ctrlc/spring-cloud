package com.sa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sa.domain.Permission;
import com.sa.mapper.PermissionMapper;
import com.sa.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author sa
 * @date 2020-04-17
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}