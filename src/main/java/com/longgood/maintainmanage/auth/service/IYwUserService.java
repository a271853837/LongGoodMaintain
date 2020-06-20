package com.longgood.maintainmanage.auth.service;

import com.longgood.maintainmanage.auth.entity.YwUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
public interface IYwUserService extends IService<YwUser> {
    YwUser Login(String userName, String password);
}
