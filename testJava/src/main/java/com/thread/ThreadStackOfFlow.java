package com.thread;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by dengyayun on 17/10/18.
 */
public class ThreadStackOfFlow implements Runnable {

    public void run() {
        try {
            System.out.println(new ArrayList<String>().get(0));
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("error");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1) {
                });

        for(int i=0; i<10; i++) {
            Thread.sleep(1000);
            executor.submit(new ThreadStackOfFlow());
            System.out.println(executor.getPoolSize());
        }
//        System.out.println(new ArrayList<String>().get(0));

    }
}