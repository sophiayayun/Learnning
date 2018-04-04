package com;

import java.util.concurrent.*;

/**
 * Created by dengyayun on 18/4/2.
 */
public class ThreadLeakTest {

    public static void main(String[] args) {
        //有一个线程池, 然后线程处理时会出现异常, 导致 线程池中无可用的线程

        ThreadPoolExecutor excutor = new ThreadPoolExecutor(100, 200, 100, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(300));
//        ExecutorService excutor = Executors.newFixedThreadPool(200);

        for (int i=1;i<300;i++) {
            LeakTask t1 = new LeakTask(i, excutor, i+ "mythread");
            excutor.submit(t1);
        }

//        for (int i = 0; i <300 ; i++) {
//            Executor
//        }

        excutor.shutdown();
//        System.out.println( 10/0);
    }
}
