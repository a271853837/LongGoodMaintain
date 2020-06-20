package com.longgood.maintainmanage.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.longgood.maintainmanage.auth.entity.YwUser;
import com.longgood.maintainmanage.auth.mapper.YwUserMapper;
import com.longgood.maintainmanage.auth.service.IYwUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@Service
public class YwUserServiceImpl extends ServiceImpl<YwUserMapper, YwUser> implements IYwUserService {
    @Autowired
    private YwUserMapper userMapper;

    public YwUser Login(String userName, String password) {
        QueryWrapper<YwUser> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(YwUser::getUsername,userName).eq(YwUser::getLoginpwd,password);
        YwUser user = userMapper.selectOne(queryWrapper);
        return user;
    }
}
