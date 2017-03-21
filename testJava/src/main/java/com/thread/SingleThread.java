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
        for(int i = 0; i<5;i++){
            for (long k=0; k<50; k++) {
                System.out.println(this.name + " : " + i);
//                System.out.println(Thread.currentThread() + " current ");
            }
        }
         this.latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        SingleThread s1 = new SingleThread("李四", latch);
        SingleThread s2 = new SingleThread("阿三", latch);
        SingleThread s3 = new SingleThread("王五", latch);

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);

//        System.out.println("thread1 state" + t1.getState());
//        System.out.println("thread2 state" + t2.getState());
//        System.out.println("thread3 state" + t3.getState());
//        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.NORM_PRIORITY);
//        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t1.join();
        //t1.join(1000);  //等待1000毫秒不管 t1 是否执行完毕
        t2.start();
        t3.start();

//        System.out.println("after start thread1 state " + t1.getState());
//        System.out.println("after start thread2 state " + t2.getState());
//        System.out.println("after start thread3 state " + t3.getState());

//        System.out.println("thread count :" + Thread.activeCount());
//        System.out.println("stack trace: "+ Thread.getAllStackTraces());

//        for(int i = 0; i<100; i++) {
//            System.out.println("123");
//        }

//        t1.run();
//        t2.run();
//        t3.run();
        System.out.println(Thread.currentThread() + " run after thread start,not thread end! ");

        try {
            //latch 相当于主线程和各个线程通信.线程通信两种方法:共享内存&消息传递
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run after thread end!");

    }
}
