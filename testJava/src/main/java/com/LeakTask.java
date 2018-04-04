package com;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by dengyayun on 18/4/2.
 */
public class LeakTask extends Thread {

    int num;
    int a;
    ThreadPoolExecutor excutor;

    public LeakTask(int i, ThreadPoolExecutor excutor, String name){
        super(name);
        this.num =i;
        this.excutor =excutor;
    }


    public void run() {
//        Random random = new Random();
//        int ran = random.nextInt(1200);
//        if(ran=)
//        System.out.println("getActiveCount" + excutor.getActiveCount());
//        System.out.println("getPoolSize" + excutor.getPoolSize());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println( excutor.toString() );
//        if(num <= 200){
//            System.out.println(num/0);
//        }else {
//            System.out.println(num/1);
//        }
        for(;;) {}
    }
}
