package com.longgood.maintainmanage.auth.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YwDiccode implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 字典ID
     */
    private String diccodeid;

    /**
     * 字典域ID
     */
    private String domainid;

    /**
     * 字典名称
     */
    private String dicname;

    /**
     * 序号
     */
    private Integer orderno;

    /**
     * 描述
     */
    private String dsc;


}
