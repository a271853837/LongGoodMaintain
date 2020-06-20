package com.longgood.maintainmanage.auth.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YwDepart implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 部门编号
     */
    private String departid;

    /**
     * 部门名称
     */
    private String departname;

    /**
     * 父级部门编号
     */
    private String parentid;

    /**
     * 序号
     */
    private Integer orderno;

    /**
     * 备注
     */
    private String dsc;


}
