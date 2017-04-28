package com.thread;

/**
 * Created by dengyayun on 17/4/19.
 */
//该线程有可能永远都不会退出 或者 输出的number 为0(jvm 或者 cpu 对指令重排序,先赋值来了 ready为ture, 后赋值 number)
public class NoVisibility {

    public static boolean ready;
    public static int number;

    public static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println("number is :" + number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
