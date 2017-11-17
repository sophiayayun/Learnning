package com.unsecureobject;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dengyayun on 17/10/16.
 */
public class safeCollectionNotSafe {

    public static void main(String[] args) {
        // 用来测试的List
        List<String> data = new Vector<String>();
        // 用来让主线程等待10000个子线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        // 启动10000个子线程
        for (int i = 0; i < 1000; i++) {
            SampleTask2 task = new SampleTask2(data, countDownLatch);
            Thread thread = new Thread(task);
            thread.start();
        }
        try {
            // 主线程等待所有子线程执行完成，再向下执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // List的size
        System.out.println(data.size());
    }
}

//由于线程安全的集合对象是基于单个方法的同步，所以即使map是线程安全的，也会产生不同步现象。
//在非单个方法的场景下，我们仍然需要使用synchronized加锁才能保证对象的同步。

//
//        线程安全必须要使用synchronized关键字来同步控制，所以会导致性能的降低。
//        当不需要线程安全时，可以选择ArrayList，避免方法同步产生的开销；
//        当多个线程操作同一个对象时，可以选择线程安全的Vector；

//        线程不安全!=不安全
//        有人在使用过程中有一个不正确的观点：我的程序是多线程的，不能使用ArrayList要使用Vector，这样才安全。
//        线程不安全并不是多线程环境下就不能使用。
//        注意线程不安全条件：多线程操作同一个对象。比如上述代码就是在多个线程操作同一个ArrayList对象。
//        如果每个线程中new一个ArrayList，而这个ArrayList只在这一个线程中使用，那么是没问题的。

//        线程‘安全’的集合对象
//        较复杂的操作下，线程安全的集合对象也无法保证数据的同步，仍然需要我们来处理。

