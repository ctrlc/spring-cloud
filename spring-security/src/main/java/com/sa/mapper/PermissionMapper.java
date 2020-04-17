package com.sa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sa.domain.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author generation
 * @date 2020-04-17
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}