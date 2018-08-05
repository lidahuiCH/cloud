package com.spring.zipkintm.controller;

import cn.hutool.core.util.RandomUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: zjsz-user
 * @description: 服务三
 * @author: Mr.Yang
 * @create: 2018-07-03 21:58
 **/
@RestController
@RequestMapping("server3")
public class ZipkinBraveController3 {
    /**
     * @Description: 第三步调用
     * @Param:
     * @return: 字符串
     * @Author: Mr.Yang
     * @Date: 2018/7/3
     */
    @RequestMapping("/zipkin")
    public String service1() throws Exception {
        Thread.sleep(200);
        int rans = RandomUtil.randomInt(0, 3);
        if (0 == rans) {
            return "你好,欢迎进入Zipkin的世界";
        } else {
            Thread.sleep(1000);
            return "你好,欢迎进入Zipkin的世界";
        }

    }
}
