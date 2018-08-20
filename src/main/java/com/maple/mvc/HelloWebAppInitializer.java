package com.maple.mvc;

import com.maple.mvc.config.RootConfig;
import com.maple.mvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * desc: HelloWebAppInitializer
 *
 * @author hz.lei
 * @since 2018年08月08日 上午10:53
 */
public class HelloWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/", "*.html"};
    }
}
