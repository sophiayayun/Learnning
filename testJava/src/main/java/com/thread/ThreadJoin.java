package com.thread;

/**
 * Created by dengyayun on 17/3/21.
 */
public class ThreadJoin implements Runnable {

    public static int a = 0;

    public void run() {
        for (int k = 0; k < 100000; k++) {
            a = a + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Runnable r = new ThreadJoin();
        Thread t = new Thread(r);
        t.start();
//        t.join(1);   //等待1000毫秒不管 t1 是否执行完毕 ,不加 10000 就会等待t运行完毕
        System.out.println("main a: " + a);
    }
}
