package com.xdl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello
 *
 * @author xdl
 * @date 2018-08-30
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String applicationName;


    @GetMapping("/hello")
    public String hello() {
        discoveryClient.getInstances(applicationName).forEach((ServiceInstance s) -> {
            log.info("/hello，host:{}，service_id:{}", s.getHost(), s.getServiceId());
        });
        return "Hello World";
    }

}
