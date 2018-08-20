package com.maple.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * desc: RootConfig
 *
 * @author hz.lei
 * @since 2018年08月20日 上午10:51
 */
@Configuration
@ComponentScan("com.maple.mvc")
@ImportResource("classpath:spring-context.xml")
public class RootConfig {

}
