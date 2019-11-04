package com.maple.controller;

import com.maple.mvc.controller.aspect.Custom;
import com.maple.mvc.controller.vo.AppRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * desc: RestController
 *
 * @author hz.lei
 * @since 2018年08月08日 上午10:53
 */
@RestController
@RequestMapping("/json")
public class JsonController {
    @Resource(name = "tx_h2_dataSource")
    private DataSource dataSource;

    @RequestMapping("/test")
    @Custom
    public String toTest(@RequestBody AppRequest request) {

        System.out.println(request.toString());

        String resource = ResourceProcessor.getResource(dataSource);
        System.out.println(resource);
        return resource;
    }


}
