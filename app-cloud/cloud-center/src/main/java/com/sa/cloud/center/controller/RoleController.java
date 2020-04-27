package com.sa.cloud.center.controller;

import com.sa.cloud.base.domain.center.Permission;
import com.sa.cloud.base.domain.center.Role;
import com.sa.cloud.center.service.PermissionService;
import com.sa.cloud.center.service.RoleService;
import com.sa.comm.web.framework.web.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController extends BaseAction {

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;


    /**
     * 分页查询角色
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/list")
    public void list(HttpServletRequest request, HttpServletResponse response) {
        List<Role> datas = roleService.listRole(null);



        for (Role role : datas) {
            List<Permission> permissions = permissionService.findPermissionByRoleId(role.getId());
            List<Object> permissionTree = permissionService.getPermissionTree(permissions);


            if (role.getId() == 1) {
                role.setKey("admin");
            } else {
                role.setKey("editor");
            }
            role.setRoutes(permissionTree);
        }

        this.responseSuccess(datas, request, response);
    }


    /*@RequestMapping(value = "/list")
    public void list(HttpServletRequest request, HttpServletResponse response) {
        List<Role> datas = roleService.listRole(null);



        for (Role role : datas) {
            List<Permission> permissions = permissionService.findPermissionByRoleId(role.getId());
            List<TreeDTO> permissionTree = permissionService.getPermissionTree(permissions);


            if (role.getId() == 1) {
                role.setKey("admin");
            } else {
                role.setKey("editor");
            }
            role.setRoutes(permissionTree);
        }

        this.ajaxObjectSuccess(datas, request, response);
    }*/


}
