package com.maple.mvc.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author maple 2018.10.06 12:57 PM
 */
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("=================> AfterHelloWorldApplicationContextInitializer applicationContext: " + applicationContext.getId());
    }
}
