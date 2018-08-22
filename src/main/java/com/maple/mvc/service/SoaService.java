package com.maple.mvc.service;

import java.util.concurrent.CompletableFuture;

/**
 * desc: SoaService
 *
 * @author hz.lei
 * @since 2018年08月21日 下午4:39
 */
public class SoaService {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture future1 = new CompletableFuture();
//        future1.complete(1);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("begin future");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println("end future");
            throw new RuntimeException("error");
//            return "1";
        });
        System.out.println(1);


        future.whenComplete((result, e) -> {
            if (e != null) {
                System.out.println("complete3: " + e.getMessage());
            }
            System.out.println(result + " complete 3...");
        });

        future.whenComplete((result, e) -> {
            if (e != null) {
                System.out.println("complete3: " + e.getMessage());
            }
            System.out.println(result + " complete 1...");
        });

        future.whenComplete((result, e) -> {
            if (e != null) {
                System.out.println("complete3: " + e.getMessage());
            }
            System.out.println(result + " complete 2...");
        });


        Thread.sleep(Long.MAX_VALUE);

    }

    /**
     * 异步api：使用创建CompletableFuture类提供的工厂方法与getPriceAsync()效果完全一致
     * 可以更轻易的完成这个流程，并且不用担心实现细节
     * @param product
     * @return
     */
//    public Future<Double> getPriceAsyncByFactory(String product){

//        return CompletableFuture.supplyAsync(() -> calculatePrice(product));

//    }

}
