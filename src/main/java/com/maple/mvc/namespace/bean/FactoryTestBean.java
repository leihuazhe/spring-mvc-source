package com.maple.mvc.namespace.bean;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

/**
 * desc: FactoryTestBean
 *
 * @author hz.lei
 * @since 2018年08月17日 上午12:29
 */
public class FactoryTestBean implements SmartLifecycle {

    private String name;

    private Object bean;

    private volatile boolean isrunning = false;


    public void doGetBean() {
        System.err.println("解析的bean:" + bean + ", bean名字：" + name);
    }

    @Override
    public void start() {
        System.err.println("FactoryTestBean 我被创建了");
    }

    @Override
    public void stop() {
        System.out.println("FactoryTestBean stop");
    }

    @Override
    public boolean isRunning() {
        return isrunning;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setBean(Object bean) {
        this.bean = bean;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        callback.run();
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
