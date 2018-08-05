package com.spring.sericefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
@Service
public interface SchedualServiceHi {

    @RequestMapping(value = "/max", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name, @RequestParam(value = "name") String foo);
}
