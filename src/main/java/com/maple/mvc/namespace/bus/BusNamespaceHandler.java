package com.maple.mvc.namespace.bus;

import org.springframework.beans.factory.xml.NamespaceHandler;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * {@link NamespaceHandler} for Event Bus configuration namespace.
 *
 * @author hz.lei
 * @since 2018年08月17日 上午12:13
 */
public class BusNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("producer", new ProducerBeanDefinitionParser());
        registerBeanDefinitionParser("consumer", new ConsumerBeanDefinitionParser());
    }
}
