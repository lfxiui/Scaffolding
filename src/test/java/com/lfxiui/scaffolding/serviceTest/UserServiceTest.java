package com.lfxiui.scaffolding.serviceTest;

import com.lfxiui.scaffolding.model.user.User;
import com.lfxiui.scaffolding.service.user.UserService;
import com.lfxiui.scaffolding.util.PasswordUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author lfxiui
 * @date 2018/2/27 0027 10:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


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

    @Test
    public void tetsCache() throws Exception {
        PasswordUtil passwordUtil = new PasswordUtil();
        User user = new User();
        user.setAccount("test");
        user.setPassword(passwordUtil.md5Password("test", passwordUtil.getSalt()));
        user.setNickname("测试");
        userService.insertUser(user);

        User user1 = userService.getUserByAccount("test");
        assertEquals(user1.getNickname(), "测试");

        User user2 = userService.getUserByAccount("test");
        assertEquals(user2.getNickname(), "测试");

        user2.setNickname("测试测试");
        userService.updateUser(user2);
        User user3 = userService.getUserByAccount("test");
        assertEquals(user3.getNickname(), "测试测试");

        userService.deleteUserByAccount("test");
        assertNull(userService.getUserByAccount("test"));
    }
}
