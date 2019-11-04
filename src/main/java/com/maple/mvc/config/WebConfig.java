package com.maple.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.*;

/**
 * desc: WebConfig
 *
 * @author hz.lei
 * @since 2018年08月20日 上午10:51
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan("com.maple.controller")
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix("/WEB-INF/").suffix(".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/eywa-web/**").addResourceLocations("/eywa-web/");
    }
}
