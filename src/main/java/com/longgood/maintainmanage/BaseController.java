package com.longgood.maintainmanage;

import com.longgood.maintainmanage.common.ResponseUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseController {
    public void renderJson(HttpServletResponse response, String json){
        ResponseUtils.renderJson(response,json);
    }
}
