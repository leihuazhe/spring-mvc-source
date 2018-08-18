package com.maple.mvc.namespace.bus;

import com.today.eventbus.spring.MsgAnnotationBeanPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanDefinitionStoreException;
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
public class ConsumerBeanDefinitionParser extends AbstractBeanDefinitionParser {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        Boolean isEnable = Boolean.valueOf(element.getAttribute("enable"));
        if (isEnable) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MsgAnnotationBeanPostProcessor.class);
            builder.getRawBeanDefinition().setSource(parserContext.extractSource(element));
            logger.info("eventBus consumer config msgAnnotationBeanPostProcessor is enable, " +
                    "then it will start to scan the bean which has  @KafkaConsumer annotation.");
            return builder.getBeanDefinition();
        }
        logger.info("eventBus consumer config msgAnnotationBeanPostProcessor is not enable, " +
                "we will not start the postProcessor to scan bean which has  @KafkaConsumer annotation.");
        return null;
    }

    @Override
    protected String resolveId(Element element, AbstractBeanDefinition definition, ParserContext parserContext) throws BeanDefinitionStoreException {
        String id = super.resolveId(element, definition, parserContext);
        if (id != null && !"".equals(id)) {
            return id;
        }
        return "msgProcessorId";
    }


}
