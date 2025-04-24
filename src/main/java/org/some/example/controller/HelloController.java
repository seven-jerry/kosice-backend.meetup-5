package org.some.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/hello")
public class HelloController {

    @Value("${test.property}") String prop;

    @GetMapping()
    public String sayHello() {
        return "Hello my name should be "+prop ;
    }
}
