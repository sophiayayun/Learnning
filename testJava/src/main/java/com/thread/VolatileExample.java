package com.thread;

/**
 * Created by dengyayun on 17/5/2.
 */
//不知道怎么看出来 插入屏障指令
public class VolatileExample {
    public int a = 0;
    public boolean flag = false;
    public int result = -1;

    public void write(){
        a = 1;
        flag = true;
    }

    public void reader(){
        if(flag) {
            result = a*a;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int count=0;

        while(true) {
            final VolatileExample volatileExample = new VolatileExample();

            Thread one = new Thread(new Runnable() {
                public void run() {
                    volatileExample.write();
                }
            });

            Thread two = new Thread(new Runnable() {
                public void run() {
                    volatileExample.reader();
                }
            });

            one.start();
            two.start();
            one.join();
            two.join();

            count++;
            System.out.println("第 " + count +" 次 : result: " + volatileExample.result);

            if(volatileExample.result == 0) break;
        }
    }
}
