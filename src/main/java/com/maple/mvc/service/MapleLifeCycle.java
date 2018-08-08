package com.maple.mvc.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * desc: MapleLifeCycle
 *
 * @author hz.lei
 * @since 2018年08月08日 上午11:31
 */
@Service
public class MapleLifeCycle implements InitializingBean, ApplicationContextAware {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("========>   afterPropertiesSet MapleLifeCycle");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext===>  " + applicationContext);
    }
}
