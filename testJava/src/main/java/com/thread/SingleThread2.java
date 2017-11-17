package com.thread;

/**
 * Created by dengyayun on 17/3/20.
 */
public class SingleThread2 extends Thread {

    public String name;

    public SingleThread2(String name) {
        this.name = name;
    }

    public void run(){
        for(int i = 0; i<5;i++){
            for (long k=0; k<10; k++) {
                System.out.println(this.name + " : " + i);
            }
        }
    }

    public static void main(String[] args) {
        SingleThread2 s1 = new SingleThread2("李四");
        SingleThread2 s2 = new SingleThread2("阿三");
        SingleThread2 s3 = new SingleThread2("王五");

        s1.start();
        s2.start();
        s3.start();
//        s1.run();
//        s2.run();
//        s3.run();
        System.out.println("这是主线程,我要结束了");
    }
}
