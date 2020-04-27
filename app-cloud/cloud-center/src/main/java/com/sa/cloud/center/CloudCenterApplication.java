package com.sa.cloud.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sa.cloud.*", "com.sa.cloud.*.*"})
@MapperScan("com.sa.cloud.**.mapper")
public class CloudCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCenterApplication.class, args);
    }

}
