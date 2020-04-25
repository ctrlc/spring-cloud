package com.sa.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.common.config.JWTConfig;
import com.sa.common.util.JWTTokenUtil;
import com.sa.common.util.ResultUtil;
import com.sa.domain.User;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义登录拦截器，接收前端传递的json数据 Account and password are incorrect
 *
 * @author sa
 * @date 2020-04-18
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        System.out.println(request.getContentType());
        //当Content-Type为json时尝试身份验证
        if (request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {

            //use jackson to deserialize json
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream is = request.getInputStream()) {
                AuthenticationBean authenticationBean = mapper.readValue(is, AuthenticationBean.class);
                authRequest = new UsernamePasswordAuthenticationToken(
                        authenticationBean.getUsername(), authenticationBean.getPassword());
            } catch (IOException e) {
                e.printStackTrace();
                new UsernamePasswordAuthenticationToken("", "");
            } finally {
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }

        //transmit it to UsernamePasswordAuthenticationFilter
        else {
            return super.attemptAuthentication(request, response);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User)authResult.getPrincipal();
//        user.setUsername(authResult.getName());
//        user.setAuthorities((Collection<GrantedAuthority>) authResult.getAuthorities());
        String token = JWTConfig.tokenPrefix + JWTTokenUtil.createAccessToken(user);

        Map<String, Object> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("token", token);
        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("code","000");
        codeMap.put("data", map);

        ResultUtil.responseJson(response, codeMap);
    }


}
