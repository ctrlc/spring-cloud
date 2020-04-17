package com.sa.security.service;

import com.sa.domain.User;
import com.sa.service.UserService;
import com.sa.security.domain.SelfUserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * SpringSecurity用户的业务实现
 * @Author Sans
 * @CreateTime 2019/10/1 17:21
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     * @Author Sans
     * @CreateTime 2019/9/13 17:23
     * @Param  username  用户名
     * @Return UserDetails SpringSecurity用户信息
     */
    @Override
    public SelfUserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        User user = userService.selectUserByName(username);
        if (user !=null){
            // 组装参数
            SelfUserEntity selfUserEntity = new SelfUserEntity();
            BeanUtils.copyProperties(user,selfUserEntity);
            return selfUserEntity;
        }
        return null;
    }
}