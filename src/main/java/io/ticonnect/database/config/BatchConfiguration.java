package io.ticonnect.database.config;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public BatchConfigurer batchConfigurer(DataSource dataSource){
        return new DefaultBatchConfigurer(dataSource){
            @Override
            public PlatformTransactionManager getTransactionManager() {
                return super.getTransactionManager();
            }
        };
    }

    @Bean
    public JobRepositoryFactoryBean jobRepositoryFactory(DataSource dataSource,
                                                         BatchConfigurer batchConfigurer) throws Exception {
        JobRepositoryFactoryBean bean = new JobRepositoryFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTransactionManager(batchConfigurer.getTransactionManager());
        bean.setDatabaseType("POSTGRES");
        return bean;
    }


}
