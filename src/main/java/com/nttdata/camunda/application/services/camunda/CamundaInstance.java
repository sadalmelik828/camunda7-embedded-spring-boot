package com.nttdata.camunda.application.services.camunda;

import org.camunda.bpm.application.impl.event.ProcessApplicationEventListenerPlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.engine.impl.plugin.AdministratorAuthorizationPlugin;
import org.camunda.bpm.engine.rest.security.auth.ProcessEngineAuthenticationFilter;
import org.camunda.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider;
import org.camunda.connect.plugin.impl.ConnectProcessEnginePlugin;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaInstance {

    @Bean
    public FilterRegistrationBean<ProcessEngineAuthenticationFilter> authenticationFilter() {
        FilterRegistrationBean<ProcessEngineAuthenticationFilter> registration = new FilterRegistrationBean<>();
        ProcessEngineAuthenticationFilter authFilter = new ProcessEngineAuthenticationFilter();
        registration.setFilter(authFilter);
        registration.addUrlPatterns("/engine-rest/*");
        registration.addInitParameter("authentication-provider", HttpBasicAuthenticationProvider.class.getName());
        registration.addInitParameter("rest-url-pattern-prefix", "");
        registration.setName("camunda-auth");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public ProcessEnginePlugin spinProcessEngine() {
        return new SpinProcessEnginePlugin();
    }

    @Bean
    public ProcessEnginePlugin processApplicationEventListener() {
        return new ProcessApplicationEventListenerPlugin();
    }

    @Bean
    public ProcessEnginePlugin connectProcessEngine() {
        return new ConnectProcessEnginePlugin();
    }

    @Bean
    public AdministratorAuthorizationPlugin administratorAuthorizationPlugin() {
        AdministratorAuthorizationPlugin adminAuth = new AdministratorAuthorizationPlugin();
        adminAuth.setAdministratorUserName("demo");
        return adminAuth;
    }

}
