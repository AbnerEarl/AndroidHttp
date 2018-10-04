package com.frank.ycj520.networkrequest.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Apires {
    public int status;
    public String message;
    public Object data;

    public Apires(){
        this.status = 0;
        this.message = "";
        this.data = new Object();
    }
    public Apires message(String m ){
        this.message = m;
        return this;
    }
    public Apires data(Object data ){
        this.data = data;
        return this;
    }
    public String fail(){
        this.status = 1;
        return Apires.toJSON(this);
    }
    public String fail(String msg){
        this.message(msg);
        this.status = 1;
        return Apires.toJSON(this);
    }
    public String success(){
        this.status = 0;
        return Apires.toJSON(this);
    }

    public static String toJSON(Apires as){
        return JSON.toJSONString(as, SerializerFeature.WriteMapNullValue);
    }
}