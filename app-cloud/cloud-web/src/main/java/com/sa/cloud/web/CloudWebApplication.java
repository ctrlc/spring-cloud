package com.sa.cloud.web;

import com.sa.cloud.web.config.UniqueNameGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(nameGenerator = UniqueNameGenerator.class, value = {"com.sa.*.*.*"})
@MapperScan("com.sa.cloud.base.mapper")
public class CloudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudWebApplication.class, args);
    }

}
