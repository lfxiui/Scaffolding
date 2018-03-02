package com.lfxiui.scaffolding.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 密码工具类
 *
 * @author lfxiui
 * @date 2018/3/1 0001 14:05
 */
public class PasswordUtil {
    /**
     * 获取随机生成的盐
     *
     * @return 随机生成的字符串
     */
    public final String getSalt() throws UnsupportedEncodingException {
        Random random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return new BASE64Encoder().encode(salt);
    }

    /**
     * md5加密，密码+盐，散列次数1024
     *
     * @param password 需要md5加密的密码
     * @param salt     盐
     * @return md5加密后的密码
     */
    public final String md5Password(String password, String salt) {
        return new Md5Hash(password, salt, 1024).toString();
    }
}
