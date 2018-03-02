package com.lfxiui.scaffolding.serviceTest;

import com.lfxiui.scaffolding.util.PasswordUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author lfxiui
 * @date 2018/2/27 0027 10:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {


    @Before
    public void start() throws Exception {
        System.out.println(new Date() + " UserServiceTest.class");
    }

    /**
     * 简单测试
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        PasswordUtil passwordUtil = new PasswordUtil();
        String salt = passwordUtil.getSalt();
        System.out.println(salt);
        String password = "admin";
        System.out.println(passwordUtil.md5Password(password, salt));
    }
}
