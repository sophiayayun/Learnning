package com.threadPool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dengyayun on 17/12/11.
 */
public class TaskLeak implements Runnable {

    CountDownLatch latch;

    public TaskLeak(int i, CountDownLatch countDownLatch) {
        System.out.println("my name is " + i );
        this.latch = countDownLatch;
    }

    public void run() {
        for(int i=0; i<10000;i++){

        }
//        try {
            String s=null;
            boolean eq=s.equals("");
//        }catch (Exception e) {
//
//        }
        latch.countDown();
    }
}
