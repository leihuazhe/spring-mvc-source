package com.maple.mvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * desc: LongTimeAsyncCallService
 *
 * @author hz.lei
 * @since 2018年08月20日 下午5:05
 */
@Service
public class LongTimeAsyncCallService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final int CorePoolSize = 4;
    private final int needSeconds = 3;
    private Random random = new Random();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CorePoolSize);

    public void makeRemoteCallAndUnknownWhenFinish(LongTermTaskCallback callback) {
        logger.info("完成此任务需要 : " + needSeconds + " 秒");
        scheduler.schedule(() -> {
            callback.callback("long time async call finished .");
        }, needSeconds, TimeUnit.SECONDS);
    }
}
