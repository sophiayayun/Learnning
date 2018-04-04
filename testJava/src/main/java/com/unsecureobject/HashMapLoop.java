package com.unsecureobject;

import java.util.HashMap;

/**
 * Created by dengyayun on 18/4/3.
 */
public class HashMapLoop {

    private HashMap hash = new HashMap();

    public HashMapLoop() {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    hash.put(new Integer(i), Integer.valueOf(i));
                }
                System.out.println("t1 over");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    hash.put(new Integer(i),Integer.valueOf(i));
                }
                System.out.println("t2 over");
            }
        };
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new HashMapLoop();
//        System.oucleart.println("hello");
    }

}
