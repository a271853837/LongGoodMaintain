package com.longgood.maintainmanage.auth.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统参数表
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YwSysparam implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 参数ID
     */
    private String paramid;

    /**
     * 中文名称
     */
    private String cnname;

    /**
     * 英文名称
     */
    private String enname;

    /**
     * 参数值
     */
    private String param;

    /**
     * 描述
     */
    private String dsc;


}
