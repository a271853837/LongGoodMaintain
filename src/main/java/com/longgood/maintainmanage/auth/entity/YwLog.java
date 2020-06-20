package com.longgood.maintainmanage.auth.entity;

import java.time.LocalDateTime;
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
public class YwLog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 日志ID
     */
    private String logid;

    /**
     * 日志类型（字典）
     */
    private String logtype;

    /**
     * 日志内容
     */
    private String content;

    /**
     * 日志时间
     */
    private LocalDateTime logtime;

    /**
     * 用户名称
     */
    private String username;

    /**
     * IP
     */
    private String ipaddr;


}
