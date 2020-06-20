package com.longgood.maintainmanage.auth.controller;


import com.longgood.maintainmanage.auth.entity.YwUser;
import com.longgood.maintainmanage.auth.service.IYwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@RestController
@RequestMapping("/auth/ywUser")
public class YwUserController {

    @Autowired
    private IYwUserService userService;

    @RequestMapping("/add")
    public void Add(){
        YwUser user=new YwUser();
        user.setUserid(UUID.randomUUID().toString());
        user.setUsername("aaa");
        userService.save(user);
    }
}

