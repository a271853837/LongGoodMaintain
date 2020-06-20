package com.longgood.maintainmanage.auth.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YwRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色ID
     */
    private String roleid;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 主页路径
     */
    private String url;

    /**
     * 序号
     */
    private Integer orderno;

    /**
     * 描述
     */
    private String dsc;


}
