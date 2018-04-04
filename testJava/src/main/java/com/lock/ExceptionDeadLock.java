package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dengyayun on 18/4/3.
 */
public class ExceptionDeadLock {

    Lock lock = new ReentrantLock();

    int resoure = 0;

    public void add() {
        lock.lock();
        resoure ++;
        if(resoure == 10) {
            int a = resoure/0;
        }
        lock.unlock();
    }

    public static void main(String[] args) {

        final ExceptionDeadLock exceptionDeadLock = new ExceptionDeadLock();

        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    exceptionDeadLock.add();
                }
            });
            t.start();
        }
    }
}
