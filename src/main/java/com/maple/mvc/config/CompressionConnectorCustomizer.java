package com.maple.mvc.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.util.StringUtils;

/**
 * desc: TODO
 *
 * @author hz.lei
 * @since 2018年08月22日 下午4:51
 */
public class CompressionConnectorCustomizer implements TomcatConnectorCustomizer {

    private final Compression compression;

    CompressionConnectorCustomizer(Compression compression) {
        this.compression = compression;
    }

    @Override
    public void customize(Connector connector) {
        if (this.compression != null && this.compression.getEnabled()) {
            ProtocolHandler handler = connector.getProtocolHandler();
            if (handler instanceof AbstractHttp11Protocol) {
                customize((AbstractHttp11Protocol<?>) handler);
            }
        }
    }

    private void customize(AbstractHttp11Protocol<?> protocol) {
        Compression compression = this.compression;
        protocol.setCompression("on");
        protocol.setCompressionMinSize(compression.getMinResponseSize());
        protocol.setCompressibleMimeType(
                StringUtils.arrayToCommaDelimitedString(compression.getMimeTypes()));
        if (this.compression.getExcludedUserAgents() != null) {
            protocol.setNoCompressionUserAgents(StringUtils.arrayToCommaDelimitedString(
                    this.compression.getExcludedUserAgents()));
        }
    }

}
