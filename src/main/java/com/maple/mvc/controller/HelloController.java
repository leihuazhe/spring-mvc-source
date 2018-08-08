package com.maple.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc: RestController
 *
 * @author hz.lei
 * @since 2018年08月08日 上午10:53
 */
@RestController
public class HelloController {


    @RequestMapping("/")
    public String sayHello() {
        return "hello";
    }
}
