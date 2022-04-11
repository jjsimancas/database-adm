package io.ticonnect.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:database.properties")
})
public class DatabaseAdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseAdmApplication.class, args);
    }

}
