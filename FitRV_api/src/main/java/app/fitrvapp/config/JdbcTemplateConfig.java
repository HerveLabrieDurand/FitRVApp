package app.fitrvapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
public class JdbcTemplateConfig {

    @Autowired
    @Qualifier("myDataSource")
    private DriverManagerDataSource dataSource;

    @Bean(name = "myJdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}

