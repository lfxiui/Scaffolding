package com.lfxiui.scaffolding.serviceTest;

import com.lfxiui.scaffolding.mapper.SUserMapper;
import com.lfxiui.scaffolding.model.SUser;
import com.lfxiui.scaffolding.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService service;
    @Autowired
    private SUserMapper sUserMapper;

    @Before
    public void start() throws Exception{
        System.out.println(new Date()+" UserServiceTest.class");
    }

    /**
     * 简单测试
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        System.out.println(sUserMapper.all());
        SUser sUser = new SUser();
        sUser.setId((long) 1);
        sUserMapper.selectByPrimaryKey(sUser);
//        service.getSUserPageInfo();
    }
}
