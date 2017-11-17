package com.unsecureobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dengyayun on 17/10/16.
 */

//        线程安全就是多线程访问时，采用了加锁机制，当一个线程访问该类的某个数据时，进行保护，其他线程不能进行访问直到该线程读取完，其他线程才可使用。不会出现数据不一致或者数据污染。
//        线程不安全就是不提供数据访问保护，多线程先后更改数据会产生数据不一致或者数据污染的情况。
//        一般使用synchronized关键字加锁同步控制，来解决线程不安全问题。
//        2、线程安全的集合对象
//
//        ArrayList线程不安全，Vector线程安全；
//        HashMap线程不安全，HashTable线程安全；
//        StringBuilder线程不安全，StringBuffer线程安全。
//        3、代码测试
//
//        ArrayList线程不安全：
//        在主线程中新建100个子线程，分别向ArrayList中添加100个元素，最后打印ArrayList的size。

public class UnsafeArrayList {

    public static void main(String [] args){
        // 用来测试的List,
//        List<String> data = new ArrayList<String>();
        List<String> data = new Vector<String>();
        // 用来让主线程等待100个子线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(100);
        // 启动100个子线程
        for(int i=0;i<100;i++){
            SampleTask task = new SampleTask(data,countDownLatch);
            Thread thread = new Thread(task);
            thread.start();
        }
        try{
            // 主线程等待所有子线程执行完成，再向下执行
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // List的size
        System.out.println(data.size());
    }
}

//list 更换成 Vector 也会有线程安全, 同时如果 在data 上加锁也是可以保证的
