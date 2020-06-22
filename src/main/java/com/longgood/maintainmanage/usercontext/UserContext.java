package com.longgood.maintainmanage.usercontext;

import com.longgood.maintainmanage.auth.entity.YwUser;

public class UserContext {

    private static ThreadLocal<YwUser> userThreadLocal = new ThreadLocal<>();

    private UserContext(){

    }

    public static void addUser(YwUser user){
        userThreadLocal.set(user);
    }

    public static YwUser getUser(){
        YwUser user = userThreadLocal.get();
        return user;
    }

    public static void removeUser(){
        userThreadLocal.remove();
    }
}
