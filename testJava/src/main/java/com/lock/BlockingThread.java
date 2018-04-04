package com.lock;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dengyayun on 18/4/4.
 */
public class BlockingThread {

    final Object o =new Object();

    public void block() {

        synchronized (o) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    final int a = 10;



    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,200, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(10));
        final BlockingThread blockingThread = new BlockingThread();

//
        for (int i = 0; i < 30; i++) {
            executor.submit(new Thread(new Runnable() {
                public void run() {
                    blockingThread.block();
                }
            }));
        }

    }


}
