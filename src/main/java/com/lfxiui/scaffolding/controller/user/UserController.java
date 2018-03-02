package com.lfxiui.scaffolding.controller.user;

import com.lfxiui.scaffolding.model.user.User;
import com.lfxiui.scaffolding.service.user.UserService;
import com.lfxiui.scaffolding.util.JsonFormat;
import com.lfxiui.scaffolding.util.PasswordUtil;
import com.lfxiui.scaffolding.util.ReturnUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 18:25
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 测试
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public JsonFormat test() {
        return new JsonFormat(200, "测试", "测试");
    }

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonFormat login(@RequestBody User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return new JsonFormat(200, "登陆成功", null);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public JsonFormat signUp(@RequestBody User user) throws UnsupportedEncodingException {
        PasswordUtil passwordUtil = new PasswordUtil();
        String salt = passwordUtil.getSalt();
        user.setSalt(salt);
        user.setPassword(passwordUtil.md5Password(user.getPassword(), salt));
        if (userService.insertUser(user) == 1) {
            return new JsonFormat(200, "注册成功", null);
        } else {
            return ReturnUtil.getResult(1016, null);
        }
    }

    /**
     * 没有登陆
     *
     * @return
     */
    @RequestMapping(value = "/unauthc", method = RequestMethod.GET)
    public JsonFormat unauthc() {
        return ReturnUtil.getResult(1999, null);
    }
}
