package com.sa.service.impl;

import com.sa.domain.Inventory;
import com.sa.mapper.InventoryMapper;
import com.sa.service.InventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存信息表 服务实现类
 * </p>
 *
 * @author sa
 * @since 2020-05-11
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements InventoryService {

}
