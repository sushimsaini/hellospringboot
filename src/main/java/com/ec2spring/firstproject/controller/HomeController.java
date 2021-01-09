package com.ec2spring.firstproject.controller;

import com.ec2spring.firstproject.controller.service.WriteToS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    WriteToS3 writeToS3;


    @GetMapping("/home")
    public String home() {
       // writeToS3.createBucketAndPutObject();
        return "Hello World ! this is AWS :)";
    }

}
