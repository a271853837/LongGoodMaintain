package com.longgood.maintainmanage.auth.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YwUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @TableId
    private String userid;

    /**
     * 部门ID
     */
    private String departid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 别名
     */
    private String alias;

    /**
     * 登录密码
     */
    private String loginpwd;

    /**
     * 签字密码
     */
    private String signpwd;

    /**
     * 座机号码
     */
    private String mobileno;

    /**
     * 手机号码
     */
    private String phoneno;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * Email
     */
    private String email;

    /**
     * 职位（字典）
     */
    private String post;

    /**
     * 状态（字典）
     */
    private String status;

    /**
     * 是否短信验证
     */
    private Integer ismsg;

    /**
     * 序号
     */
    private Integer orderno;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastlogintime;

    /**
     * 图章路径
     */
    private String sealpath;

    /**
     * 备注
     */
    private String dsc;

    /**
     * 1 有编制
0 无编制
     */
    private Integer isbz;

    /**
     * 短信验证码
     */
    private String msgcode;

    /**
     * 验证码时间
     */
    private LocalDateTime msgtime;

    private String photo;

    /**
     * 是否uk登录
     */
    private Integer isuk;

    /**
     * 加密狗序号
     */
    private String pincode;

}
