package com.lfxiui.scaffolding.util;

/**
 * JSON格式
 *
 * @author lfxiui
 * @date 2018/2/28 0028 15:08
 */
public class JsonFormat {
    private int code;
    private String info;
    private Object data;

    public JsonFormat(int code, String info, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
