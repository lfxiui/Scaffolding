package com.lfxiui.scaffolding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lfxiui
 * @date 2018年2月27日10点39分
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.lfxiui.scaffolding.mapper")
public class ScaffoldingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaffoldingApplication.class, args);
	}
}
