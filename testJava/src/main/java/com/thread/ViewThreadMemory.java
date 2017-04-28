package com.thread;

/**
 * Created by dengyayun on 17/4/7.
 */
//运行改程序,可以通过 jvisualvm 命令查看内存情况
public class ViewThreadMemory implements Runnable {

    public void run() {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        for(int i=0; i<100; i++) {
            ViewThreadMemory v = new ViewThreadMemory();
            Thread t = new Thread(v);
            t.start();
        }
    }
}
