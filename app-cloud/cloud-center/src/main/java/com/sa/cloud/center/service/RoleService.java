package com.sa.cloud.center.service;

import com.sa.cloud.base.domain.center.Role;

import java.util.List;

public interface RoleService {

    /**
     * 查询角色
     *
     * @param role
     * @return
     */
    List<Role> listRole(Role role);

    /**
     * 增加角色
     *
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 删除角色
     *
     * @param role
     * @return
     */
    int deleteRole(Role role);

    /**
     * 更新角色
     *
     * @param role
     * @return
     */
    int updateRole(Role role);
}
