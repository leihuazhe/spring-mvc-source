package com.maple.mvc.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextClosedEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * desc: GracefulShutdown 优雅停机
 *
 * @author hz.lei
 * @since 2018年06月23日 下午5:29
 */
public class GracefulShutdown  {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private volatile Connector connector;

    private final int waitTime = 60;


    public void customize(Connector connector) {
        this.connector = connector;
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        //设置最大连接数
//        protocol.setMaxConnections(2000);
        //设置最大线程数
//        protocol.setMaxThreads(200);
        protocol.setMinSpareThreads(100);
//        protocol.setConnectionTimeout(30000);
    }

    /**
     * 3次,每次3s
     *
     * @param contextClosedEvent
     */
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
//        HealthCheckController.status = ContainerStatus.YELLOW;
        logger.info("睡眠15s,等待tengine踢出当前web服务");
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            logger.error("睡眠线程被打断: " + e.getMessage(), e);
        }
        logger.info("准备关闭容器，先关闭线程!");
        this.connector.pause();
        Executor executor = this.connector.getProtocolHandler().getExecutor();

        if (executor instanceof ThreadPoolExecutor) {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                threadPoolExecutor.shutdown();

                if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {

                    logger.warn("Tomcat thread pool did not shut down gracefully within " + waitTime
                            + " seconds. Proceeding with forceful shutdown");
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
