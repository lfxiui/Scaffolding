package com.lfxiui.scaffolding.controller.user;

import com.lfxiui.scaffolding.model.user.User;
import com.lfxiui.scaffolding.service.user.UserService;
import com.lfxiui.scaffolding.util.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:25
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public JsonFormat test(){
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        return new JsonFormat(200,"success",userList);
    }
}
