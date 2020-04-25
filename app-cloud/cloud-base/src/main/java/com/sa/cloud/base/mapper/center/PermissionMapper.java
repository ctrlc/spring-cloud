package com.sa.cloud.base.mapper.center;

import com.sa.cloud.base.domain.center.Permission;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PermissionMapper {

    /**
     * 查询所有权限
     *
     * @return
     */
    List<Permission> findAll();

    int deleteByPrimaryKey(Long id);

    int insert(Permission permission);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Permission permission);

    List<Permission> findPermissionByRoleId(Long id);
}
