package com.spring.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chengchaoyin on 2017/12/7.
 */

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @GetMapping(value = "/hello")
    public String hello(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello,host:"+instance.getHost() + ",service_id:"+instance.getServiceId());
        return "Hello world";
    }
}
