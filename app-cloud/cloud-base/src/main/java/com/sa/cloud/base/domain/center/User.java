package com.sa.cloud.base.domain.center;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private String userName;

    private String passWord;

    private String trueName;

    private Byte sex;

    private String address;

    private String idCard;

    private Date createTime;

    private Date updateTime;

}
