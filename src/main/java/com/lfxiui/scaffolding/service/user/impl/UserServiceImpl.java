package com.lfxiui.scaffolding.service.user.impl;

import com.lfxiui.scaffolding.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:45
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

}
