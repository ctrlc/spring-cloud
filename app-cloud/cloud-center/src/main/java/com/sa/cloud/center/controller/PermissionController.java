package com.sa.cloud.center.controller;

import com.sa.cloud.base.domain.center.Permission;
import com.sa.cloud.center.service.PermissionService;
import com.sa.comm.web.framework.web.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 权限
 *
 * @author sa
 * @date 2020-04-09
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController extends BaseAction {

    @Autowired
    PermissionService permissionService;


    /**
     * 分页查询角色
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/allPermission")
    public void allPermission(HttpServletRequest request, HttpServletResponse response) {
        List<Permission> permissions = permissionService.findAll();
        List<Object> permissionTree = permissionService.getPermissionTree(permissions);
        this.resultSuccess(permissionTree, request, response);
    }


    @RequestMapping(value = "/rolePermission")
    public void rolePermission(HttpServletRequest request, HttpServletResponse response) {
        List<Permission> permissions = permissionService.findPermissionByRoleId(1L);
        List<Object> permissionTree = permissionService.getPermissionTree(permissions);
        this.resultSuccess(permissionTree, request, response);
    }


    /*@RequestMapping(value = "/allPermission")
    public void allPermission(HttpServletRequest request, HttpServletResponse response) {
        List<Permission> permissions = permissionService.findAll();
        List<TreeDTO> permissionTree = permissionService.getPermissionTree(permissions);
        this.ajaxObjectSuccess(permissionTree, request, response);
    }


    @RequestMapping(value = "/rolePermission")
    public void rolePermission(HttpServletRequest request, HttpServletResponse response) {
        List<Permission> permissions = permissionService.findPermissionByRoleId(1L);
        List<TreeDTO> permissionTree = permissionService.getPermissionTree(permissions);
        this.ajaxObjectSuccess(permissionTree, request, response);
    }*/
}
