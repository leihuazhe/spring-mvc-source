import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.*;

/**
 * 多线程put的时候可能导致元素丢失
 * HashMap另外一个并发可能出现的问题是，可能产生元素丢失的现象。
 * <p>
 * 考虑在多线程下put操作时，执行addEntry(hash,key, value, i)，如果有产生哈希碰撞，
 * 导致两个线程得到同样的bucketIndex去存储，就可能会出现覆盖丢失的情况：。同时存进去的位置，有一个先存的会给覆盖掉。
 *
 * @author <a href=mailto:leihuazhe@gmail.com>Maple Ray</a>
 * @since 2018-12-20 1:29 PM
 */
@Slf4j
public class ThreadTest1 {

    private static int threadNum = 200;
    private static int requestNum = 5000;

    private static Map<Integer, Integer> counter = new HashMap<>();


    private static List<Integer> cahceList = Collections.synchronizedList(new ArrayList());


    private static Semaphore semaphore = new Semaphore(threadNum);

    private static CountDownLatch latch = new CountDownLatch(requestNum);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < requestNum; i++) {
            final int index = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    func(index);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }
        latch.await();
        executorService.shutdown();
        log.info("counter: {}", counter.size());
        log.info("cacheList: {}", cahceList.size());


    }

    public static void func(int num) {
        counter.put(num, num);
        cahceList.add(num);
        log.info("put num {}", num);
    }


}
