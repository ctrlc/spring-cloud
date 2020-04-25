package com.sa.cloud.base.mapper.center;

import com.sa.cloud.base.domain.center.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role role);

    List<Role> listRole(Role role);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Role role);
}
