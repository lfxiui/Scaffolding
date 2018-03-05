package com.lfxiui.scaffolding.config;

import com.lfxiui.scaffolding.util.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置
 *
 * @author lfxiui
 * @date 2018/3/1 0001 17:34
 */
@Configuration
public class ShiroConfig {
    /**
     * shiro拦截器配置
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        System.out.println(new Date() + "Shiro拦截器");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //拦截项,顺序判断,LinkedHashMap有序
        Map<String, String> filterMap = new LinkedHashMap<>();
        //静态资源,spring boot默认映射路径
        filterMap.put("/css/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/fonts/**", "anon");
        //打开页面
        filterMap.put("/", "anon");
        //退出，由shiro实现
        filterMap.put("/logout", "logout");
        //登陆
        filterMap.put("/user/login", "anon");
        //注册
        filterMap.put("/user/signUp", "anon");
        //判断是否已经登陆
        filterMap.put("/user/isLogin", "anon");
        //获取验证码图片
        filterMap.put("/user/getVCodePic", "anon");
        //余下所有项拦截
        filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/user/unauthc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义的用户验证
     *
     * @param hashedCredentialsMatcher 密码加密方式
     * @return
     */
    @Bean
    public UserRealm userRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return userRealm;
    }

    /**
     * 密码加密方式配置md5，散列次数为1024
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }

    @Bean
    public SecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
}
