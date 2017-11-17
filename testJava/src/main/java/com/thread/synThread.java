package com.thread;

/**
 * Created by dengyayun on 17/10/9.
 */
public class synThread implements Runnable {

    public synchronized void run() {
            for (int i = 0; i < 500; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
    }

    public static void main(String[] args) {
//        synThread t1 = new synThread();
//        synThread t2 = new synThread();
//        Thread ta = new Thread(t1, "A");
//        Thread tb = new Thread(t1, "B");
//        ta.start();
//        tb.start();

//        SynchronizedCounter s1 = new SynchronizedCounter();
//        SynchronizedCounter s2 = new SynchronizedCounter();
//        Thread ta = new Thread(s1,"A");
//        Thread tb = new Thread(s2,"B");
//        ta.start();
//        tb.start();

    }
}
