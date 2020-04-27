package com.sa.cloud.center.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sa.cloud.center.system.domain.Role;
import com.sa.cloud.center.system.service.RoleService;
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
 * 角色表 前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/role")
public class RoleAction extends BaseAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    RoleService roleService;


    /**
    * 角色表 保存数据
    *
    * @param request
    * @param response
    * @param jsonObject
    */
    @RequestMapping(value = "/saveRole")
    public void saveRole(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Role role = jsonObject.toJavaObject(Role.class);
        try {
            roleService.save(role);
            this.responseSuccess("数据保存成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据保存失败!", request, response);
        }
    }


    /**
     * 角色表 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listRole")
    public void listRole(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Role role = jsonObject.toJavaObject(Role.class);
        IPage<Role> page = jsonObject.toJavaObject(Page.class);
        Wrapper<Role> queryWrapper = new QueryWrapper<>(role);
        try {
            IPage<Role> list = roleService.page(page, queryWrapper);
            this.responseSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("分页查询失败!", request, response);
        }
    }


    /**
     * 角色表 修改数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateRole")
    public void updateRole(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Role role = jsonObject.toJavaObject(Role.class);
        try {
            roleService.updateById(role);
            this.responseSuccess("数据修改成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据修改失败!", request, response);
        }
    }


    /**
     * 角色表 删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removeRole")
    public void removeRole(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Role role = jsonObject.toJavaObject(Role.class);
        try {
            roleService.removeById(role);
            this.responseSuccess("数据删除成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据删除失败!", request, response);
        }
    }

}

