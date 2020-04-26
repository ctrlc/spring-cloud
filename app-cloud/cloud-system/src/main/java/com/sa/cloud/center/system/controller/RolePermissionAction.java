package com.sa.cloud.center.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sa.cloud.center.system.domain.RolePermission;
import com.sa.cloud.center.system.service.RolePermissionService;
import com.sa.comm.web.framework.web.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p>
 * 角色权限关联表 前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/rolePermission")
public class RolePermissionAction extends BaseAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    RolePermissionService rolePermissionService;


    /**
    * 角色权限关联表 保存数据
    *
    * @param request
    * @param response
    * @param jsonObject
    */
    @RequestMapping(value = "/saveRolePermission")
    public void saveRolePermission(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        RolePermission rolePermission = jsonObject.toJavaObject(RolePermission.class);
        try {
            rolePermissionService.save(rolePermission);
            this.resultSuccess("数据保存成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.resultFailure("数据保存失败!", request, response);
        }
    }


    /**
     * 角色权限关联表 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listRolePermission")
    public void listRolePermission(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        RolePermission rolePermission = jsonObject.toJavaObject(RolePermission.class);
        IPage<RolePermission> page = jsonObject.toJavaObject(Page.class);
        Wrapper<RolePermission> queryWrapper = new QueryWrapper<>(rolePermission);
        try {
            IPage<RolePermission> list = rolePermissionService.page(page, queryWrapper);
            this.resultSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.resultFailure("分页查询失败!", request, response);
        }
    }


    /**
     * 角色权限关联表 修改数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateRolePermission")
    public void updateRolePermission(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        RolePermission rolePermission = jsonObject.toJavaObject(RolePermission.class);
        try {
            rolePermissionService.updateById(rolePermission);
            this.resultSuccess("数据修改成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.resultFailure("数据修改失败!", request, response);
        }
    }


    /**
     * 角色权限关联表 删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removeRolePermission")
    public void removeRolePermission(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        RolePermission rolePermission = jsonObject.toJavaObject(RolePermission.class);
        try {
            rolePermissionService.removeById(rolePermission);
            this.resultSuccess("数据删除成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.resultFailure("数据删除失败!", request, response);
        }
    }

}

