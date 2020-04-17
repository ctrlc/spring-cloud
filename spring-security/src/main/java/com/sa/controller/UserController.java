package com.sa.controller;

import com.sa.common.util.ResultUtil;
import com.sa.domain.Permission;
import com.sa.service.PermissionService;
import com.sa.security.domain.SelfUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 普通用户
 * @Author Sans
 * @CreateTime 2019/10/2 14:43
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 用户端信息
     * @Author Sans
     * @CreateTime 2019/10/2 14:52
     * @Return Map<String,Object> 返回数据MAP
     */
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String,Object> userLogin(){
        Map<String,Object> result = new HashMap<>();
        SelfUserEntity userDetails = (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        result.put("title","用户端信息");
        result.put("data",userDetails);
        return ResultUtil.resultSuccess(result);
    }

    /**
     * 拥有USER角色和sys:user:info权限可以访问
     * @Author Sans
     * @CreateTime 2019/10/2 14:22
     * @Return Map<String,Object> 返回数据MAP
     */
    @PreAuthorize("hasRole('USER') and hasPermission('/user/menuList','sys:user:info')")
    @RequestMapping(value = "/menuList",method = RequestMethod.GET)
    public Map<String,Object> sysMenuEntity(){
        Map<String,Object> result = new HashMap<>();
        List<Permission> sysMenuEntityList = permissionService.list();
        result.put("title","拥有USER角色和sys:user:info权限可以访问");
        result.put("data",sysMenuEntityList);
        return ResultUtil.resultSuccess(result);
    }

}
