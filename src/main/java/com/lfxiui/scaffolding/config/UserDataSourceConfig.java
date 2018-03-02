package com.lfxiui.scaffolding.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 用户数据源配置
 *
 * @author lfxiui
 * @date 2018/2/28 0028 11:26
 */
@Configuration
@MapperScan(basePackages = UserDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "userSqlSessionFactory")
public class UserDataSourceConfig {
    static final String PACKAGE = "com.lfxiui.scaffolding.mapper.user";
    static final String MAPPER_XML = "classpath:mapper/user/*.xml";

    @Value("${user.datasource.url}")
    private String url;

    @Value("${user.datasource.username}")
    private String username;

    @Value("${user.datasource.password}")
    private String password;

    @Value("${user.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "userDataSource")
    public DataSource userDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager userTransactionManager() {
        return new DataSourceTransactionManager(userDataSource());
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource userDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(userDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(UserDataSourceConfig.MAPPER_XML));
        return sessionFactoryBean.getObject();
    }
}
