package com.longgood.maintainmanage.jwt;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.longgood.maintainmanage.auth.entity.YwUser;
import com.longgood.maintainmanage.auth.service.IYwUserService;
import com.longgood.maintainmanage.common.ResponseUtils;
import com.longgood.maintainmanage.common.ResultMessage;
import com.longgood.maintainmanage.usercontext.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*/
token拦截器
 */
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
            //验证成功 通过
            if (JwtUtils.verify(token)){
                UserContext.addUser(JwtUtils.getUser(token));
                return true;
            }else{
                //验证失败 则刷新过期token并重新获得token
                String newToken = JwtUtils.createToken(JwtUtils.getUser(token));
                ResponseUtils.renderJson(response, ResultMessage.success(newToken));
                return false;
            }
        }
        catch (Exception ex){
            UserContext.removeUser();
            ResponseUtils.renderJson(response, ResultMessage.error(ex.getMessage()));
            return false;
        }

    }

}

