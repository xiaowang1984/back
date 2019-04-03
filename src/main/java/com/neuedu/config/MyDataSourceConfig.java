package com.neuedu.config;

import com.neuedu.util.MyPropertyPlaceholderConfigurer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class MyDataSourceConfig {
    @Value("${driver}")
    String driver;
    @Value("${url}")
    String url;
    @Value("${username}")
    String username;
    @Value("${password}")
    String password;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driver);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setMinimumIdle(8);
        hikariConfig.setMaximumPoolSize(20);
        return new HikariDataSource(hikariConfig);
    }
}
