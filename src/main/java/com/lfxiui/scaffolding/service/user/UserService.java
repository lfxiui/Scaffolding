package com.lfxiui.scaffolding.service.user;

import com.lfxiui.scaffolding.model.user.User;

/**
 * 用户模块业务层接口
 *
 * @author lfxiui
 * @date 2018/2/26 0026 18:44
 */
public interface UserService {
    /**
     * 根据用户账号条件查询用户
     * 如果缓存存在，从缓存中获取用户信息
     * 如果不存在缓存中，则从DB中获取用户信息，并将信息存入缓存中
     *
     * @param userAccount 用户账号
     * @return 返回查询到的完整用户信息
     */
    User getUserByAccount(String userAccount);

    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return 插入数量，返回1为正确数据
     */
    Integer insertUser(User user);

    /**
     * 更新用户信息
     * 如果缓存存在，删除缓存
     * 如果缓存不存在，不操作
     *
     * @param user 需要更新的用户
     * @return Integer成功更新条数
     */
    Integer updateUser(User user);

    /**
     * 删除用户
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     *
     * @param userAccount 需要删除用户账号
     * @return Integer成功删除条数
     */
    Integer deleteUserByAccount(String userAccount);
}
