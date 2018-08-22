package com.maple.mvc;

import com.maple.mvc.config.TomcatServletWebServerFactory;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

/**
 * desc: Main
 *
 * @author hz.lei
 * @since 2018年08月22日 下午6:15
 */
public class Main {


    public static void main(String[] args) throws LifecycleException, ServletException {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        Tomcat webServer = factory.getWebServer();
        webServer.start();
        webServer.getServer().await();


    }


}
