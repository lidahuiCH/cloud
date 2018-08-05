package com.spring.sericefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "config-client", fallback = SchedualConfigClientHystric.class)
@Service
public interface SchedualConfigClient {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne();
}
