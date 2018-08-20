package com.maple.mvc.beans.context;

import com.github.dapeng.org.apache.thrift.TException;
import com.maple.eventbus.bus.EventBus;
import com.maple.mvc.beans.lookup.BikeProvider;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * desc: listener
 * 该类在 spring-mvc 中进行注册即可.
 * 不然可能会导致多次 ContextRefreshedEvent 刷新
 *
 * @author hz.lei
 * @since 2018年08月16日 下午11:43
 */
@MvcBean
public class ContextEventListener implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {
    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        boolean root_webApplicationContext = "Root WebApplicationContext".equals(event.getApplicationContext().getDisplayName());
        //root application context 没有parent，他就是老大.
        if (event.getApplicationContext().getParent() == null) {
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
        }
        BikeProvider provider = applicationContext.getBean(BikeProvider.class);

        provider.hello();

            EventBus.dispatchEvent("大佬！");


//        FactoryTestBean bean = applicationContext.getBean(FactoryTestBean.class);
//        bean.doGetBean();


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
