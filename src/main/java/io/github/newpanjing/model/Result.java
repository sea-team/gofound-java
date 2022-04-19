package io.github.newpanjing.model;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回结果
 */
public class Result {

    private boolean state;
    private String message;
    private Object data;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static Result parse(String text) {
        return JSONObject.parseObject(text, Result.class);
    }
}
