package com.sa.security.handler;

import com.sa.comm.web.framework.web.BaseAction;
import com.sa.common.config.JWTConfig;
import com.sa.common.util.JWTTokenUtil;
import com.sa.common.util.ResultUtil;
import com.sa.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 登录成功处理类
 * @Author Sans
 * @CreateTime 2019/10/3 9:13
 */
@Slf4j
@Component
public class UserLoginSuccessHandler extends BaseAction implements AuthenticationSuccessHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 登录成功返回结果
     * @Author Sans
     * @CreateTime 2019/10/3 9:27
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        try {
            // 组装JWT
            User user = (User) authentication.getPrincipal();
            String token = JWTTokenUtil.createAccessToken(user);
            token = JWTConfig.tokenPrefix + token;
            // 封装返回参数
            Map<String, Object> data = new HashMap<>();
            data.put("token", token);
            this.responseSuccess(data, request, response);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
    }
}
