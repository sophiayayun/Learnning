package com.thread;

/**
 * Created by dengyayun on 17/4/13.
 */
public class SynchronizedCounter {

    long count = 0;
    static long staticCount =0;

    //**instanceMethod ,instanceMethodMoudle  每次只有一个线程能够在这两个方法中执行, 因为他们都是对 实例对象加锁

    //实例方法同步:同步在拥有该方法的对象上. 一个线程一次可以在一个实例同步快中执行操作
    public synchronized void instanceMethod(long value){
        this.count =+value;
    }

    //实例方法同步块: 同步块构造器用括号将对象括起来。使用了“this”，即为调用 add 方法的实例本身. 在同步构造器中用括号括起来的对象叫做监视器对象
    public void instanceMethodMoudle(long value) {
        synchronized(this) {
            this.count =+value;
        }
    }

    //与add2 效果相似??
    public void instanceMethodMoudle2(long value) {
        synchronized(SynchronizedCounter.class) {
            this.count =+value;
        }
    }

    //*** add1 ,add2  这两个方法不允许同时被线程访问

    //静态方法同步:同步在该方法所属的类上, java 虚拟机中一个类只有一个类对象, 一个线程执行同一个类中的静态方法同步块
    public static synchronized void add1(long value){
        staticCount =+value;
    }

    //静态方法同步块:
    public static void add2(long value) {
        synchronized (SynchronizedCounter.class) {
            staticCount =+ value;
        }
    }

}
