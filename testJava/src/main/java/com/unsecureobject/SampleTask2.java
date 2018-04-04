package com.unsecureobject;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dengyayun on 17/10/16.
 */
public class SampleTask2 implements Runnable {
    CountDownLatch countDownLatch;
    List<String> data;

    public SampleTask2(List<String> data, CountDownLatch countDownLatch) {
        this.data = data;
        this.countDownLatch = countDownLatch;
    }

    public  void run() {
            int size = data.size();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        data.add(size, "1");
        data.add("1");
            // 完成一个子线程
            countDownLatch.countDown();
    }
}
