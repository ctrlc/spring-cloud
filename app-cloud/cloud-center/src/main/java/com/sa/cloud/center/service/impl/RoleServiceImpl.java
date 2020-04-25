package com.sa.cloud.center.service.impl;

import com.sa.cloud.base.domain.center.Role;
import com.sa.cloud.base.mapper.center.RoleMapper;
import com.sa.cloud.center.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> listRole(Role role) {
        return roleMapper.listRole(role);
    }

    @Override
    public int insertRole(Role role) {
        return 0;
    }

    @Override
    public int deleteRole(Role role) {
        return 0;
    }

    @Override
    public int updateRole(Role role) {
        return 0;
    }
}
