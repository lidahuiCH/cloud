package com.spring.sericefeign;

import org.springframework.stereotype.Component;

@Component
public class SchedualConfigClientHystric implements SchedualConfigClient {
    @Override
    public String sayHiFromClientOne() {
        return "get confit error ";
    }
}
