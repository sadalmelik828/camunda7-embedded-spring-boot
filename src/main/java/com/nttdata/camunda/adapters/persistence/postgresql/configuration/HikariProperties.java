package com.nttdata.camunda.adapters.persistence.postgresql.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * DmnProperties.
 * @author NTT Data
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "persistence.postgresql.hikari")
public class HikariProperties {

    private String poolName;
    private long keepAliveTime;
    private long maxLifeTime;
    private long connectionTimeout;
    private long idleTimeout;
    private int minimumIdle;
    private int maximumPoolSize;
}
