package com.maple.mvc.namespace;

import com.maple.mvc.namespace.bean.FactoryTestBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * desc: ConsumerBeanDefinitionParser
 *
 * @author hz.lei
 * @since 2018年08月17日 上午12:15
 */
public class MapleBeanDefinitionParser extends AbstractBeanDefinitionParser {

    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(FactoryTestBean.class);
        builder.addPropertyValue("name", element.getAttribute("name"));
        builder.addPropertyReference("bean", element.getAttribute("ref"));
        builder.getRawBeanDefinition().setSource(parserContext.extractSource(element));
        return builder.getBeanDefinition();
    }
}
