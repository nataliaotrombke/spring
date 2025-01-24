package com.github.nataliaotrombke.demodata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DemoDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDataApplication.class, args);
    }

}
