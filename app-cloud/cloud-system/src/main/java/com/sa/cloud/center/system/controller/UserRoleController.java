package com.sa.cloud.center.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sa.cloud.center.system.domain.UserRole;
import com.sa.cloud.center.system.service.UserRoleService;
import com.sa.comm.web.framework.web.BaseController;
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
 * 用户角色关联表 前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController extends BaseController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    UserRoleService userRoleService;


    /**
    * 用户角色关联表 保存数据
    *
    * @param request
    * @param response
    * @param jsonObject
    */
    @RequestMapping(value = "/saveUserRole")
    public void saveUserRole(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        UserRole userRole = jsonObject.toJavaObject(UserRole.class);
        try {
            userRoleService.save(userRole);
            this.responseSuccess("数据保存成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据保存失败!", request, response);
        }
    }


    /**
     * 用户角色关联表 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listUserRole")
    public void listUserRole(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        UserRole userRole = jsonObject.toJavaObject(UserRole.class);
        IPage<UserRole> page = jsonObject.toJavaObject(Page.class);
        Wrapper<UserRole> queryWrapper = new QueryWrapper<>(userRole);
        try {
            IPage<UserRole> list = userRoleService.page(page, queryWrapper);
            this.responseSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("分页查询失败!", request, response);
        }
    }


    /**
     * 用户角色关联表 修改数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateUserRole")
    public void updateUserRole(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        UserRole userRole = jsonObject.toJavaObject(UserRole.class);
        try {
            userRoleService.updateById(userRole);
            this.responseSuccess("数据修改成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据修改失败!", request, response);
        }
    }


    /**
     * 用户角色关联表 删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removeUserRole")
    public void removeUserRole(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        UserRole userRole = jsonObject.toJavaObject(UserRole.class);
        try {
            userRoleService.removeById(userRole);
            this.responseSuccess("数据删除成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据删除失败!", request, response);
        }
    }

}

