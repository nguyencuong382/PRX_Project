/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author nc
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.setProperty("server.port", "8086");
        System.setProperty("server.servlet.context-path=", "rest");
        System.setProperty("spring.security.enabled", "false");
        System.setProperty("spring.mvc.dispatch-options-request", "true");
        System.setProperty("spring.profiles", "dev");
        System.setProperty("spring.main.banner-mode", "off");
        System.setProperty("spring.datasource.driverClassName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.setProperty("spring.datasource.url", "jdbc:sqlserver://localhost;databaseName=PRX");
        System.setProperty("spring.datasource.username", "sa");
        System.setProperty("spring.datasource.password", "123");
        System.setProperty("spring.jpa.database", "sql-server");
        System.setProperty("spring.jpa.properties.hibernate.format_sql", "true");
        System.setProperty("spring.jpa.properties.hibernate.use_sql_comments", "true");
        System.setProperty("spring.jpa.properties.hibernate.show_sql", "true");
        System.setProperty("spring.jpa.hibernate.id.new_generator_mappings", "false");
        System.setProperty("spring.jpa.hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
        System.setProperty("spring.jpa.hibernate.naming.implicit-strategy", "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");
        System.setProperty("spring.jpa.hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        System.setProperty("spring.jpa.show-sql", "true");
        System.setProperty("management.security.enabled", "false");
        System.setProperty("security.basic.enabled", "false");
        System.setProperty("security.enable-csrf", "false");
        System.setProperty("security", "ignored=/**");

        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        System.out.println("Server runing on 8086");
    }
}
