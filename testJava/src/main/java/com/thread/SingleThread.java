package com.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dengyayun on 17/3/20.
 */
public class SingleThread implements Runnable {

    public String name;
    public CountDownLatch latch;

    public SingleThread(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    public void run(){
        for(int i = 0; i<50000;i++){
            for (long k=0; k<50000; k++) {
                long j = i+k;
                System.out.println(this.name + " : " + i);
//                System.out.println(Thread.currentThread() + " current ");
            }
        }
//         this.latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        SingleThread s1 = new SingleThread("李四", latch);
        SingleThread s2 = new SingleThread("阿三", latch);
        SingleThread s3 = new SingleThread("王五", latch);

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);

        t1.start();
        //t1.join(1000);  //等待1000毫秒不管 t1 是否执行完毕
        t2.start();
        t3.start();
//        t1.join();

//        System.out.print
        System.out.println(Thread.currentThread() + " run after thread start,not thread end! ");

//        try {
//            //latch 相当于主线程和各个线程通信.线程通信两种方法:共享内存&消息传递
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("run after thread end!");

    }
}
