package com.maple.mvc;

import com.maple.mvc.filter.CharacterEncodingFilter;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * desc: ServletApplicationInitializer
 *
 * @author hz.lei
 * @since 2018年08月22日 上午10:35
 */
public class ServletApplicationInitializer implements ServletContainerInitializer {


    @Override
    public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext)
            throws ServletException {


        servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);

        servletContext.log("Maple Spring WebApplicationInitializers detected on classpath");

    }

}