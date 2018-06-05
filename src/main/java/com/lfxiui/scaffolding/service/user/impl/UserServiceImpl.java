package com.lfxiui.scaffolding.service.user.impl;

import com.lfxiui.scaffolding.mapper.user.UserMapper;
import com.lfxiui.scaffolding.model.user.User;
import com.lfxiui.scaffolding.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:45
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public User getUserByAccount(String userAccount) {
        LOGGER.info("获取用户信息start...");
        //从缓存中获取用户信息
        String key = "user_" + userAccount;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        //缓存存在
        boolean hashKey = redisTemplate.hasKey(key);
        if (hashKey) {
            User user = operations.get(key);
            LOGGER.info("从缓存中获取用户Account=" + userAccount);
            return user;
        }

        //缓存不存在，从DB中获取
        User user = new User();
        user.setAccount(userAccount);
        user = userMapper.selectOne(user);
        //插入缓存中
        operations.set(key, user, 10, TimeUnit.SECONDS);

        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertUser(User user) {
        LOGGER.info("新增用户start...");
        return userMapper.insertSelective(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateUser(User user) {
        LOGGER.info("更新用户信息start...");
        int result = userMapper.updateByPrimaryKey(user);
        String userAccount = user.getAccount();

        //缓存存在，删除缓存
        String key = "user_" + userAccount;
        boolean hashKey = redisTemplate.hasKey(key);
        if (hashKey) {
            redisTemplate.delete(key);
            LOGGER.info("更新用户信息，从缓存中删除用户 >>" + userAccount);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteUserByAccount(String userAccount) {
        LOGGER.info("删除用户start...");
        String key = "user_" + userAccount;
        User user = new User();
        user.setAccount(userAccount);
        int result;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        //缓存存在
        boolean hashKey = redisTemplate.hasKey(key);
        if (hashKey) {
            user = operations.get(key);
            result = userMapper.deleteByPrimaryKey(user);
            redisTemplate.delete(key);
            LOGGER.info("删除用户时，从缓存中删除用户");
            return result;
        }

        //缓存不存在
        user = userMapper.selectOne(user);
        result = userMapper.deleteByPrimaryKey(user);
        return result;
    }
}
