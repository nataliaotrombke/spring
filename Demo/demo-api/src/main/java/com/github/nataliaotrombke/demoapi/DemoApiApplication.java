package com.github.nataliaotrombke.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// https://stackoverflow.com/a/77381508
@ComponentScan(basePackages = {"com.github.nataliaotrombke"})
public class DemoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }

}
