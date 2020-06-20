package com.longgood.maintainmanage.auth.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YwModules implements Serializable {

    private static final long serialVersionUID=1L;

    private String moduleid;

    private String modulename;

    private String accessurl;

    private Integer inbuilt;

    private Integer orderno;

    private String parentid;

    private String icon;


}
