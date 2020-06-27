package com.medium.cb;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/")
    public String test() {
        return "started";
    }


    @RequestMapping("/_cb")
    public String testMethod() {
        System.out.println("Controller");
        return testService.testMethod();
    }


}
