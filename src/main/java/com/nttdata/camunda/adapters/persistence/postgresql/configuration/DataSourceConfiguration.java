package com.nttdata.camunda.adapters.persistence.postgresql.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    private final DataSourceProperties dataSourceProperties;

    private final HikariProperties hikariProperties;

    public DataSourceConfiguration(
        DataSourceProperties dataSourceProperties,
        HikariProperties hikariProperties) {
        this.dataSourceProperties = dataSourceProperties;
        this.hikariProperties = hikariProperties;
    }

    @Bean(name = "camundaBpmDataSource")
    public DataSource postgresDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariConfig.setJdbcUrl(dataSourceProperties.getJdbcUrl());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        hikariConfig.setPoolName(hikariProperties.getPoolName());
        hikariConfig.setKeepaliveTime(hikariProperties.getKeepAliveTime());
        hikariConfig.setMaxLifetime(hikariConfig.getMaxLifetime());
        hikariConfig.setConnectionTimeout(hikariProperties.getConnectionTimeout());
        hikariConfig.setIdleTimeout(hikariProperties.getIdleTimeout());
        hikariConfig.setMinimumIdle(hikariProperties.getMinimumIdle());
        hikariConfig.setMaximumPoolSize(hikariProperties.getMaximumPoolSize());
        return new HikariDataSource(hikariConfig);
    }
}
