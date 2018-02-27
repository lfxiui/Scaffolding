package com.lfxiui.scaffolding.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfxiui.scaffolding.mapper.SUserMapper;
import com.lfxiui.scaffolding.model.SUser;
import com.lfxiui.scaffolding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private SUserMapper sUserMapper;
    @Override
    public PageInfo<SUser> getSUserPageInfo() {
        PageHelper.startPage(1,10);
        List<SUser> sUserList = sUserMapper.selectAll();
        return new PageInfo<SUser>(sUserList);
    }
}
