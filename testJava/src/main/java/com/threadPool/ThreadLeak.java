package com.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dengyayun on 17/12/11.
 */
public class ThreadLeak {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(30);
        ThreadPoolExecutor excutor = new ThreadPoolExecutor(10,20,1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

        for(int i=0; i<30; i++) {
            excutor.submit(new TaskLeak(i,latch));
        }

        try {
            //latch 相当于主线程和各个线程通信.线程通信两种方法:共享内存&消息传递
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(excutor.getActiveCount());
        System.out.println(excutor.getCompletedTaskCount());

        excutor.shutdown();

    }
}
