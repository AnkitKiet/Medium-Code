package com.medium.cb;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class TestService {

    RestTemplate restTemplate;

    TestService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public String testMethod() {

        System.out.println("Inside");
        URI uri = URI.create("http://localhost:8080/fetchall");

        return this.restTemplate.getForObject(uri, String.class);

    }



    public String fallback() {
        return "I am serving something to be used as fallback stuff";
    }
}
