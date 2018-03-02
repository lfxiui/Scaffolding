package com.lfxiui.scaffolding.service.user;

import com.lfxiui.scaffolding.model.user.User;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:44
 */
public interface UserService {
    /**
     * 条件查询用户信息
     *
     * @param user 用户账号
     * @return 返回查询到的完整用户信息
     */
    User getUser(User user);

    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return 插入数量，返回1为正确数据
     */
    Integer insertUser(User user);
}
