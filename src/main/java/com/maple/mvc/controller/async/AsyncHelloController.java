package com.maple.mvc.controller.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * desc: AsyncHelloController
 *
 * @author hz.lei
 * @since 2018年08月20日 上午10:02
 */
//@RestController
//@Async
public class AsyncHelloController {

//    @RequestMapping("/async")
    public Callable<String> async() throws InterruptedException {
        Callable<String> callable = () -> {
            Thread.sleep(5000);

//            logger.info("实际工作执行完成！");

            return "succeed!";
        };
        Thread.sleep(20000);
        return callable;
    }


}
