package com.vaadin.tutorial.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication(
        exclude = ErrorMvcAutoConfiguration.class,
        scanBasePackages = {"hu.hellp", "com.vaadin.tutorial.crm"}
)
@EnableJpaAuditing
public class VaadinTutorialApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VaadinTutorialApplication.class, args);
    }

}
