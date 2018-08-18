package com.maple.mvc.namespace.bus;

import com.today.eventbus.scheduler.MsgPublishTask;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

/**
 * desc: ConsumerBeanDefinitionParser
 *
 * @author hz.lei
 * @since 2018年08月17日 上午12:15
 */
public class ProducerBeanDefinitionParser extends AbstractBeanDefinitionParser {

    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        Element kafkaConfigElement = DomUtils.getChildElementByTagName(element, "kafka-config");
        Element taskPollElement = DomUtils.getChildElementByTagName(element, "task-poll");
        Element bizBusBeanElement = DomUtils.getChildElementByTagName(element, "biz-bus-bean");
        Object source = parserContext.extractSource(element);

        element.getElementsByTagName("kafka-config");

        String topic = kafkaConfigElement.getAttribute("topic");
        String kafkaHost = kafkaConfigElement.getAttribute("kafka-host");
        String tidPrefix = kafkaConfigElement.getAttribute("kafka-tid-prefix");
        String dataSource = taskPollElement.getAttribute("data-source");
        String serviceName = taskPollElement.getAttribute("service-name");

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MsgPublishTask.class);
        builder.addConstructorArgValue(topic);
        builder.addConstructorArgValue(kafkaHost);
        builder.addConstructorArgValue(tidPrefix);
        builder.addConstructorArgReference(dataSource);
        builder.addPropertyValue("serviceName", serviceName);
        builder.setInitMethodName("startScheduled");
        builder.getRawBeanDefinition().setSource(parserContext.extractSource(element));
        return builder.getBeanDefinition();
    }

    @Override
    protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws BeanDefinitionStoreException {
        String id = super.resolveId(element, definition, parserContext);
        if (id != null && !"".equals(id)) {
            return id;
        }
        return "msgPublishId";
    }
}
