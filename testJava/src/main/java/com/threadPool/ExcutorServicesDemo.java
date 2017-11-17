package com.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dengyayun on 17/10/18.
 */
public class ExcutorServicesDemo {

    public static void main(String[] args) {
        //使用 SynchronousQueue, 耗时短的程序, 任务处理速度 > 任务提交速度
        ExecutorService service = Executors.newCachedThreadPool();

        //使用LinkedBlockingQueue
        ExecutorService service2 = Executors.newFixedThreadPool(10);

        //
        ExecutorService service3 = Executors.newSingleThreadExecutor();

        //
        ExecutorService service4 = Executors.newScheduledThreadPool(10);

        for (int i=0; i<10; i++) {
            service.submit(new MyTask(i));
        }


    }

    static class myTask implements Runnable {

        int num;

        myTask(int i) {
            this.num =i;
        }
        public void run() {
            System.out.println("thread "+ num + " start");
            for(int i=0;i<1000000; i++) {

            }
            System.out.println("thread "+ num + " end");
        }
    }
}
