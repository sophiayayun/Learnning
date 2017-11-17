package com.thread;

import java.util.concurrent.*;

/**
 * Created by dengyayun on 17/10/10.
 */
public class CallableDemo implements Callable<String> {

    public String name;

    public CallableDemo(String name) {
        this.name = name;
    }


    public String call() throws Exception {
        System.out.println("call");
        TimeUnit.SECONDS.sleep(1);
        return this.name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo demo1 = new CallableDemo("demo1");
        CallableDemo demo2 = new CallableDemo("demo2");

        FutureTask<String> future1 = new FutureTask<String>(demo1);
        FutureTask<String> future2 = new FutureTask<String>(demo2);

        long beginTime = System.currentTimeMillis();
        // 创建线程
        new Thread(future1).start();
        new Thread(future2).start();

        // 调用get()阻塞主线程，反之，线程不会阻塞
        String result = future1.get();
        String result2 = future2.get();
        long endTime = System.currentTimeMillis();
        System.out.println("hello : " + result);
        System.out.println("hello : " + result2);
        System.out.println("cast : " + (endTime - beginTime) / 1000 + " second!");
    }
}
