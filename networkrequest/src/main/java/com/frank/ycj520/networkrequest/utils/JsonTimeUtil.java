package com.frank.ycj520.networkrequest.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;

/**
 * Created by 黄庆 on 2017/12/31.
 */

//将 jsonObject 转换成 对象

public class JsonTimeUtil {
    private static SerializeConfig mapping = new SerializeConfig();
    private static String[] dateFormat={"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd","yyyy-MM-dd HH:mm"};
    /**
     * 默认的处理时间
     *
     * @param jsonText
     * @return
     */
    public static String toJSON(Object jsonText) {
        return JSON.toJSONString(jsonText,
                SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * 自定义时间格式
     *
     * @param jsonText
     * @return
     */
    public static String toDatetimeJSONString(Object jsonText) {
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat[0]));
        return JSON.toJSONString(jsonText, mapping).replaceAll("\"","");
    }
    public static String toDateMinJSONString(Object jsonText) {
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat[2]));
        return JSON.toJSONString(jsonText, mapping).replaceAll("\"","");
    }
    public static String toDateJSONString(Object jsonText) {
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat[1]));
        return  JSON.toJSONString(jsonText, mapping).replaceAll("\"","");
    }
}
