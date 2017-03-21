package com.thread;

/**
 * Created by dengyayun on 17/3/21.
 */
public class ThreadJoin implements Runnable {

    public static int a = 0;

    public void run() {
        for (int k = 0; k < 10000; k++) {
            a = a + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Runnable r = new ThreadJoin();
        Thread t = new Thread(r);
        t.start();
//        t.join();
        System.out.println("main a: " + a);
    }
}
