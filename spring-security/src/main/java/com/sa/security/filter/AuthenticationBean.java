package com.sa.security.filter;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationBean {
    private String username;
    private String password;
}
