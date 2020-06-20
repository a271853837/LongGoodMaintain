package com.longgood.maintainmanage.jwt;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.longgood.maintainmanage.auth.entity.YwUser;
import com.longgood.maintainmanage.auth.service.IYwUserService;
import com.longgood.maintainmanage.common.ResponseUtils;
import com.longgood.maintainmanage.common.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private IYwUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!StringUtils.isNotBlank(token)){
            ResponseUtils.renderJson(response, ResultMessage.error("token is null"));
            return false;
        }
        try{
            if (JwtUtils.verify(token)){
                return true;
            }else{
                String newToken = JwtUtils.createToken(JwtUtils.getUser(token));
                ResponseUtils.renderJson(response, ResultMessage.success(newToken));
                return false;
            }

        }
        catch (Exception ex){
            ResponseUtils.renderJson(response, ResultMessage.error(ex.getMessage()));
            return false;
        }

    }

}

