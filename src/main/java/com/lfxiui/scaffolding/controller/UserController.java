package com.lfxiui.scaffolding.controller;

import com.github.pagehelper.PageInfo;
import com.lfxiui.scaffolding.model.SUser;
import com.lfxiui.scaffolding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:25
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserPageInfo",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<SUser> getUserPageInfo(){
        return userService.getSUserPageInfo();
    }
}
