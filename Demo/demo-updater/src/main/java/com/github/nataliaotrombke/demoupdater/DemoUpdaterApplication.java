package com.github.nataliaotrombke.demoupdater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // https://spring.io/guides/gs/scheduling-tasks
@SpringBootApplication
// https://stackoverflow.com/a/77381508
@ComponentScan(basePackages = {"com.github.nataliaotrombke"})
public class DemoUpdaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUpdaterApplication.class, args);
    }

}
