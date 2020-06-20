package com.longgood.maintainmanage.login;

import com.longgood.maintainmanage.BaseController;
import com.longgood.maintainmanage.auth.entity.YwUser;
import com.longgood.maintainmanage.auth.service.IYwUserService;
import com.longgood.maintainmanage.common.ResultMessage;
import com.longgood.maintainmanage.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private IYwUserService userService;
    @RequestMapping("/loginin")
    public void LoginIn(YwUser ywUser, HttpServletRequest request, HttpServletResponse response){
        YwUser login = userService.Login(ywUser.getUsername(), ywUser.getLoginpwd());
        if (login!=null){
            //ywUser.setLogindate(Calendar.getInstance().getTime());
            String token = JwtUtils.createToken(login);
            renderJson(response, ResultMessage.data(token));
        }else{
            renderJson(response, ResultMessage.error("用户密码错误"));
        }
    }
}
