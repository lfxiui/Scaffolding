package com.lfxiui.scaffolding.service.user.impl;

import com.lfxiui.scaffolding.mapper.user.UserMapper;
import com.lfxiui.scaffolding.model.user.User;
import com.lfxiui.scaffolding.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertSelective(user);
    }
}
