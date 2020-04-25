package com.sa.cloud.base.domain.center;

import lombok.Data;

import java.util.Date;

@Data
public class Permission {
    private Long id;

    private String title;

    private Long parentId;

    private String perms;

    private String path;

    private String icon;

    private Integer sort;

    private Byte status;

    private Date createTime;

    private Date updateTime;


}
