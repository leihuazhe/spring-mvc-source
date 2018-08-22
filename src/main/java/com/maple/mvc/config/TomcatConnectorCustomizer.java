package com.maple.mvc.config;

import org.apache.catalina.connector.Connector;

/**
 * desc: TomcatConnectorCustomizer
 *
 * @author hz.lei
 * @since 2018年08月22日 下午4:41
 */
public interface TomcatConnectorCustomizer {

    /**
     * Customize the connector.
     *
     * @param connector the connector to customize
     */
    void customize(Connector connector);
}
