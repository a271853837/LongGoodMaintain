package com.longgood.maintainmanage.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GsonHelper {
    public static Gson GetJSonBuilder() {
        Map<Class, Object> adapters = new HashMap<Class, Object>();
        buildDefaultAdapter(adapters);
        return GetJSonBuilder(adapters, null);
    }

    public static Gson GetJSonBuilder(String dateFormate) {
        Map<Class, Object> adapters = new HashMap<Class, Object>();
        buildDefaultAdapter(adapters);
        return GetJSonBuilder(adapters, dateFormate);
    }

    public static Gson GetJSonBuilder(Map<Class, Object> registerAdapters, String dateFormate) {
        GsonBuilder builder = new GsonBuilder();
        if (null == dateFormate)
            dateFormate = "yyyy-MM-dd";
        builder = builder.enableComplexMapKeySerialization() // 支持Map的key为复杂对象的形式
                .serializeNulls().setDateFormat(dateFormate)// 时间转化为特定格式
                .setPrettyPrinting() // 对json结果格式化.
                .setVersion(1.0) // 有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                .disableHtmlEscaping();
        if (registerAdapters != null && registerAdapters.size() > 0) {
            for (Class clz : registerAdapters.keySet()) {
                builder.registerTypeAdapter(clz, registerAdapters.get(clz));
            }
        }
        Gson gson = builder.create();
        return gson;
    }

    /*
     * 对象转Json
     */
    public static String ToJSon(Object obj) {
        return GetJSonBuilder().toJson(obj);
    }

    public static String ToJSon(Object obj, String dateFormate) {
        return GetJSonBuilder(dateFormate).toJson(obj);
    }

    /*
     * Json转对象
     */
    public static Object FromJSon(String jsonStr, Class clz) {
        return GetJSonBuilder().fromJson(jsonStr, clz);
    }

    /**
     * 用于json转数组
     *
     * @param jsonStr
     * @param type
     * @return
     */
    public static Object FromJSon(String jsonStr, Type type) {
        return GetJSonBuilder().fromJson(jsonStr, type);
    }

    /*
     * 注册json转换adapter
     */
    private static Map<Class, Object> buildDefaultAdapter(Map<Class, Object> registerAdapters) {
        if (registerAdapters == null) {
            registerAdapters = new HashMap<Class, Object>();
        }
        return registerAdapters;
    }
    /**
     * 判断字符串是否是正确的json串
     *
     * @param json
     * @return
     */
    public static boolean isGoodJson(String json) {
        if (StringUtils.isEmpty(json))
            return false;
        try {
            JsonParser.parseString(json);
            return true;
        } catch (JsonParseException e) {
            return false;
        }
    }
}
