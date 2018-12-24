package com.abusair.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The RestServiceApplication class is responsible for run application that
 *
 * @author Khaled Absauir
 * @version 1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.abusair.hotel.*"})
public class RestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }


}
