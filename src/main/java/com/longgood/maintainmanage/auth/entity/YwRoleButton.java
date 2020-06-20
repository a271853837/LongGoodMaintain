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
public class YwRoleButton implements Serializable {

    private static final long serialVersionUID=1L;

    private String guid;

    private String roleid;

    private String buttonid;


}
