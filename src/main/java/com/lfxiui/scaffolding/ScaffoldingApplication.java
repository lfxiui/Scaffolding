package com.lfxiui.scaffolding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lfxiui
 * @date 2018年2月27日10点39分
 */
@SpringBootApplication
@EnableTransactionManagement
public class ScaffoldingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaffoldingApplication.class, args);
    }

    /**
     * 错误页面处理
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/user/test");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}
