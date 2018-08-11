package com.spring.handler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class Test2Controller {
    @RequestMapping("/t")
    public String test(String param){
        return "success";
    }
}
