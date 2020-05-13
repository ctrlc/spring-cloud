package com.sa.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sa.comm.web.framework.web.BaseAction;
import com.sa.domain.Inventory;
import com.sa.service.InventoryService;
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
 * 库存信息表 前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-05-11
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController extends BaseAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    InventoryService inventoryService;


    /**
    * 库存信息表 保存数据
    *
    * @param request
    * @param response
    * @param jsonObject
    */
    @RequestMapping(value = "/saveInventory")
    public void saveInventory(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Inventory inventory = jsonObject.toJavaObject(Inventory.class);
        try {
            inventoryService.save(inventory);
            this.responseSuccess("数据保存成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据保存失败!", request, response);
        }
    }


    /**
     * 库存信息表 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listInventory")
    public void listInventory(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Inventory inventory = jsonObject.toJavaObject(Inventory.class);
        IPage<Inventory> page = jsonObject.toJavaObject(Page.class);
        Wrapper<Inventory> queryWrapper = new QueryWrapper<>(inventory);
        try {
            IPage<Inventory> list = inventoryService.page(page, queryWrapper);
            this.responseSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("分页查询失败!", request, response);
        }
    }


    /**
     * 库存信息表 修改数据 用户认证
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateInventory")
    public void updateInventory(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Inventory inventory = jsonObject.toJavaObject(Inventory.class);
        try {
            inventoryService.updateById(inventory);
            this.responseSuccess("数据修改成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据修改失败!", request, response);
        }
    }


    /**
     * 库存信息表 删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removeInventory")
    public void removeInventory(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Inventory inventory = jsonObject.toJavaObject(Inventory.class);
        try {
            inventoryService.removeById(inventory);
            this.responseSuccess("数据删除成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据删除失败!", request, response);
        }
    }

}

