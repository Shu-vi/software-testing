package org.Generalov.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.Generalov")
@PropertySource("classpath:app.properties")
public class SpringConfig {
    @Value("${databaseUsername}")
    private String dbUsername;
    @Value("${databaseUrl}")
    private String dbUrl;
    @Value("${databasePassword}")
    private String dbPassword;


    @Bean
    @Scope(value = "singleton")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    @Scope(value = "singleton")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
