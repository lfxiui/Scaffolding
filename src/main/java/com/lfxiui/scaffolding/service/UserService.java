package com.lfxiui.scaffolding.service;

import com.github.pagehelper.PageInfo;
import com.lfxiui.scaffolding.model.SUser;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:44
 */
public interface UserService {
    /**
     * 获取用户分页信息
     * @return
     */
    PageInfo<SUser> getSUserPageInfo();
}
