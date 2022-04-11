package io.ticonnect.database.config;

import io.ticonnect.database.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static io.ticonnect.database.constants.Constants.BATCH_DATABASE;

@Configuration
public class DatabaseConfiguration {

    @Value("${postgresql.service.host}")
    private String host;

    @Value("${postgresql.service.port}")
    private int port;

    @Value("#{environment.DB_USERNAME}")
    private String username;

    @Value("#{environment.DB_PASSWORD}")
    private String password;

    @Value("${postgresql.service.databaseName}")
    private String databaseName;

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(String.format("jdbc:postgresql://%s:%d/%s", host, port, databaseName))
                .username(username)
                .password(password)
                .build();
    }

}
