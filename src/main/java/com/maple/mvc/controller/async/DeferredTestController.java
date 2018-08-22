package com.maple.mvc.controller.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc: DeferredTestController
 *
 * @author hz.lei
 * @since 2018年08月20日 下午2:11
 */
@RestController
@RequestMapping("/async")
public class DeferredTestController {
    private static final Logger logger = LoggerFactory.getLogger(DeferredTestController.class);
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

//    private DeferredResult<String> deferredResult = new DeferredResult<>();

    @Autowired
    private LongTimeAsyncCallService longTimeAsyncCallService;

    /**
     * 返回DeferredResult对象
     *
     * @return
     */
    @RequestMapping("/maple")
    public DeferredResult<String> testDeferredResult() {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        logger.info("/asynctask 调用！thread id is : " + Thread.currentThread().getId());

        longTimeAsyncCallService.makeRemoteCallAndUnknownWhenFinish(result -> {
            logger.info("异步调用执行完成, thread id is : " + Thread.currentThread().getId());
            deferredResult.setResult(result.toString());
        });
        return deferredResult;
    }

    @RequestMapping("/api")
    public DeferredResult<String> testDeferredResult1() {
        DeferredResult<String> deferredResult = new DeferredResult<>(4000L);

        deferredResult.setErrorResult("time-out");
        logger.info("/asynctask 调用！thread id is : " + Thread.currentThread().getId());
        executorService.execute(() -> {
            long needSeconds = 5;
            logger.info("完成此任务需要 : " + needSeconds + " 秒");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            deferredResult.setResult("call finished");
        });
        return deferredResult;
    }

}
