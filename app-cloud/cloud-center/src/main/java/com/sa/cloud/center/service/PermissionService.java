package com.sa.cloud.center.service;

import com.sa.cloud.base.domain.center.Permission;
import com.sa.cloud.base.domain.center.TreeDTO;

import java.util.List;

public interface PermissionService {

    /**
     * 查询所有权限
     *
     * @return
     */
    List<Permission> findAll();

    /**
     * 将权限列表数据转换成tree
     *
     * @param permissions
     */
    List<Object> getPermissionTree(List<Permission> permissions);
//    List<TreeDTO>getPermissionTree(List<Permission> permissions);

    /**
     * 根据角色ID查询权限列表
     *
     * @param roleId
     * @return
     */
    List<Permission> findPermissionByRoleId(Long roleId);

    /**
     * 根据权限ID查询权限信息
     *
     * @param id
     * @return
     */
    Permission findPermissionById(int id);


    int insertPermission(Permission permission);

    int updatePermission(Permission permission);

    int deletePermission(Permission permission);
}
