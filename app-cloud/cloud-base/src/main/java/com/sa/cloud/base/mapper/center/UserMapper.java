package com.sa.cloud.base.mapper.center;

import com.sa.cloud.base.domain.center.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User user);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKey(User user);
}
