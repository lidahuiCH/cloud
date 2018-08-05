package com.spring.sericefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    SchedualServiceHi schedualServiceHi;
    @Autowired
    SchedualConfigClient schedualConfigClient;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        String foo = schedualConfigClient.sayHiFromClientOne();
        return schedualServiceHi.sayHiFromClientOne(name, foo);
    }
}
