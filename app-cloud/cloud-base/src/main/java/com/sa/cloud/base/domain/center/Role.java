package com.sa.cloud.base.domain.center;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {
    private Long id;

    private String key= "editor";

    private String roleName;

    private String description;

    private Date createTime;

    private Date updateTime;

    private List<Object> routes;
//    private List<TreeDTO> routes;


}
