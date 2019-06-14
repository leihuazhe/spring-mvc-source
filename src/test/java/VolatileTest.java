import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>Maple Ray</a>
 * @since 2018-12-19 5:55 PM
 */
public class VolatileTest {

    private Logger logger = LoggerFactory.getLogger(VolatileTest.class);
    int a = 0;
    int b = 0;

    int x = -1;
    int y = -1;

    public void path1() {
        a = 1;
        x = b;
    }

    public void path2() {
        b = 2;
        y = a;
    }

    public boolean test() throws InterruptedException {
        a = b = 0;
        x = y = -1;
        CyclicBarrier barrier = new CyclicBarrier(2);

        Thread t1 = new Thread(() -> {
            try {
                barrier.await();
                path1();

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                barrier.await();
                path2();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        logger.info("x={},y={}", x, y);
        if (x == 0 && y == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            VolatileTest test = new VolatileTest();
            boolean test1 = test.test();

            System.out.println(test1);

        }

    }

}
