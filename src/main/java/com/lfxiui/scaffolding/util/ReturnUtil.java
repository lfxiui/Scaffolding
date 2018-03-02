package com.lfxiui.scaffolding.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据工具类
 *
 * @author lfxiui
 * @date 2018/2/28 0028 16:40
 */
public class ReturnUtil {
    private static Map<String, String> returnMap = new HashMap<>(1);

    //常用初始化状态码与文字说明
    static {
        returnMap.put("200", "访问成功！");

        returnMap.put("400", "Bad Request!");
        returnMap.put("401", "NotAuthorization");
        returnMap.put("405", "Method Not Allowed");
        returnMap.put("406", "Not Acceptable");
        returnMap.put("500", "Internal Server Error");

        returnMap.put("1000", "[服务器]运行时异常");
        returnMap.put("1001", "[服务器]空值异常");
        returnMap.put("1002", "[服务器]数据类型转换异常");
        returnMap.put("1003", "[服务器]IO异常");
        returnMap.put("1004", "[服务器]未知方法异常");
        returnMap.put("1005", "[服务器]数组越界异常");
        returnMap.put("1006", "[服务器]网络异常");

        returnMap.put("1010", "用户未注册");
        returnMap.put("1011", "用户已注册");
        returnMap.put("1012", "用户名或密码错误");
        returnMap.put("1013", "用户帐号冻结");
        returnMap.put("1014", "用户信息编辑失败");
        returnMap.put("1015", "用户信息失效，请重新获取");
        returnMap.put("1016", "注册失败");
        returnMap.put("1999", "请先登录");

        returnMap.put("1020", "验证码发送失败");
        returnMap.put("1021", "验证码失效");
        returnMap.put("1022", "验证码错误");
        returnMap.put("1023", "验证码不可用");
        returnMap.put("1029", "短信平台异常");

        returnMap.put("1030", "周边无店铺");
        returnMap.put("1031", "店铺添加失败");
        returnMap.put("1032", "编辑店铺信息失败");
        returnMap.put("1033", "每个用户只能添加一个商铺");
        returnMap.put("1034", "店铺不存在");

        returnMap.put("1040", "无浏览商品");
        returnMap.put("1041", "添加失败,商品种类超出上限");
        returnMap.put("1042", "商品不存在");
        returnMap.put("1043", "商品删除失败");

        returnMap.put("2010", "缺少参数或值为空");

        returnMap.put("2029", "参数不合法");
        returnMap.put("2020", "无效的Token");
        returnMap.put("2021", "无操作权限");
        returnMap.put("2022", "RSA解密失败,密文数据已损坏");
        returnMap.put("2023", "请重新登录");
    }

    public static JsonFormat getResult(int code, Object data) {
        return new JsonFormat(code, returnMap.get(String.valueOf(code)), data);
    }
}
