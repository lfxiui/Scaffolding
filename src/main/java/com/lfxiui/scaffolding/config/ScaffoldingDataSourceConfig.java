package com.lfxiui.scaffolding.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 主数据源配置
 *
 * @author lfxiui
 * @date 2018/2/28 0028 11:27
 */
@Configuration
@MapperScan(basePackages = ScaffoldingDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "scaffoldingSqlSessionFactory")
public class ScaffoldingDataSourceConfig {
    static final String PACKAGE = "com.lfxiui.scaffolding.mapper.scaffolding";
    static final String MAPPER_XML = "classpath:mapper/scaffolding/*.xml";

    @Value("${scaffolding.datasource.url}")
    private String url;

    @Value("${scaffolding.datasource.username}")
    private String username;

    @Value("${scaffolding.datasource.password}")
    private String password;

    @Value("${scaffolding.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "scaffoldingDataSource")
    @Primary
    public DataSource scaffoldingDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setUrl(url);
        return dataSource;
    }

    @Bean(name = "scaffoldingTransactionManager")
    @Primary
    public DataSourceTransactionManager scaffoldingTransactionManager(){
        return new DataSourceTransactionManager(scaffoldingDataSource());
    }

    @Bean(name = "scaffoldingSqlSessionFactory")
    @Primary
    public SqlSessionFactory scaffoldingSqlSessionFactory(@Qualifier("scaffoldingDataSource") DataSource scaffoldingDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(scaffoldingDataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ScaffoldingDataSourceConfig.MAPPER_XML));
        return sessionFactoryBean.getObject();
    }
}
