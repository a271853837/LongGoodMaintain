package com.longgood.maintainmanage.auth.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author lichlu
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YwUserRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 角色ID
     */
    private String roleid;

    private String guid;


}
