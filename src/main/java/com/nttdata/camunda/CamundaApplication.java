package com.nttdata.camunda;

import com.nttdata.camunda.adapters.persistence.postgresql.configuration.DataSourceProperties;
import com.nttdata.camunda.adapters.persistence.postgresql.configuration.HikariProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {DataSourceProperties.class, HikariProperties.class})
@SpringBootApplication
public class CamundaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

}
