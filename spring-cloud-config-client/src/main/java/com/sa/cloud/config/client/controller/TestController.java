package com.sa.cloud.config.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    Environment env;

    @RequestMapping(value = "/index")

    public void index(){
        String server_port = env.getProperty("server.port");
        String version = env.getProperty("version");
        logger.info("配置中心 -> server.port = {}", server_port);
        logger.info("配置中心 -> version = {}", version);
    }
}
