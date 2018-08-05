package com.spring.sericefeign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name, String foo) {
        return "sorry " + name;
    }
}
