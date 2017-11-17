package com.unsecureobject;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dengyayun on 17/10/16.
 */
public class SampleTask implements Runnable {
    CountDownLatch countDownLatch;
    List<String> data;
    public SampleTask(List<String> data,CountDownLatch countDownLatch){
        this.data = data;
        this.countDownLatch = countDownLatch;
    }
    public void run() {
        // 每个线程向List中添加100个元素
        for(int i = 0; i < 100; i++)
        {
            data.add("1");
        }
        // 完成一个子线程
        countDownLatch.countDown();
    }
}
