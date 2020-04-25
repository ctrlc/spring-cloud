package com.sa.cloud.center.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sa.cloud.center.system.domain.User;
import com.sa.cloud.center.system.service.UserService;
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
 * 用户表 前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    UserService userService;


    /**
    * 用户表 保存数据
    *
    * @param request
    * @param response
    * @param jsonObject
    */
    @RequestMapping(value = "/saveUser")
    public void saveUser(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        User user = jsonObject.toJavaObject(User.class);
        try {
            userService.save(user);
            this.responseSuccess("数据保存成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据保存失败!", request, response);
        }
    }


    /**
     * 用户表 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listUser")
    public void listUser(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        User user = jsonObject.toJavaObject(User.class);
        IPage<User> page = jsonObject.toJavaObject(Page.class);
        Wrapper<User> queryWrapper = new QueryWrapper<>(user);
        try {
            IPage<User> list = userService.page(page, queryWrapper);
            this.responseSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("分页查询失败!", request, response);
        }
    }


    /**
     * 用户表 修改数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateUser")
    public void updateUser(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        User user = jsonObject.toJavaObject(User.class);
        try {
            userService.updateById(user);
            this.responseSuccess("数据修改成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据修改失败!", request, response);
        }
    }


    /**
     * 用户表 删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removeUser")
    public void removeUser(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        User user = jsonObject.toJavaObject(User.class);
        try {
            userService.removeById(user);
            this.responseSuccess("数据删除成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据删除失败!", request, response);
        }
    }

}

