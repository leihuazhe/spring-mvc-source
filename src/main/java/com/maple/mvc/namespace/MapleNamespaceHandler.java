package com.maple.mvc.namespace;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * desc: MapleNamespaceHandler
 *
 * @author hz.lei
 * @since 2018年08月17日 上午12:13
 */
public class MapleNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("bean", new MapleBeanDefinitionParser());
    }
}
