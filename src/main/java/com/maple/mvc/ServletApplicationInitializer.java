package com.maple.mvc;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
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

        servletContext.log("Maple Spring WebApplicationInitializers detected on classpath");
    }

}