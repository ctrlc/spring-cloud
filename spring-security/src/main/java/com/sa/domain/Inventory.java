package com.sa.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 库存信息表
 * </p>
 *
 * @author sa
 * @since 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("psi_inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品类型
     */
    private String productType;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 库存数量
     */
    private Integer stockQuantity;

    /**
     * 库存可用数量
     */
    private Integer stockQuantityAvailable;

    /**
     * 库存锁定数量
     */
    private Integer stockQuantityLock;

    /**
     * 在途库存数量
     */
    private Integer stockQuantityInTransit;

    /**
     * 库存预警数量
     */
    private Integer stockQuantityAlarm;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
