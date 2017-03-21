package com.jmm;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by dengyayun on 17/3/21.
 */
public class JMMTest implements Runnable{

    public String threadName;


    public JMMTest(String name) {
        this.threadName = name;
    }

    public void run() {
        methodOne();
    }

    public void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 =
                MySharedObject.sharedInstance;

//        System.out.println(localVariable2.toString());

        //... do more with local variables.

        methodTwo();

        for(int i= 0; i<1000000; i++){
            for(int j = 0; j<100000; j++){
                System.out.println(this.threadName + " : "+ j);
            }
        }
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);

//        System.out.println(this.threadName + " : methodTwo : " + localVariable1.toString());

        //... do more with local variable.
    }

    public static void main(String[] args) {
        JMMTest j1 = new JMMTest("t1");
        JMMTest j2 = new JMMTest("t2");

        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j2);

        t1.start();
        t2.start();
    }
}



