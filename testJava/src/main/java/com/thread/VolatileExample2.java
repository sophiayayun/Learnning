package com.thread;

import java.util.Date;

/**
 * Created by dengyayun on 17/5/11.
 */
//当用x作为key的时候，不顶事儿，还是死循环。但用b作为key的时候，循环很快被解开，得到了我们预计的效果
//ava语言规范中也有指出：为了获得最佳速度，允许线程保存共享成员变量的私有拷贝，而且只当线程进入或者离开同步代码块时才将私有拷贝与共享内存中的原始值进行比较。   通俗点说就是，这里的2个变量 int x = 0;
class VolatileExample2 {

    int x = 0;
    volatile int b = 0;

    private void write() {
        x = 5;
        b = 1;
    }

    private void read() {
        while (x != 5) {
        }
//        while (b != 1) {
//        }
    }

    public static void main(String[] args) throws Exception {

        final VolatileExample2 example = new VolatileExample2();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
//确保Thread2在Thread1之前执行
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                example.write();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });

        System.out.println(System.currentTimeMillis());
        thread2.start();
        thread1.start();
        thread1.join();
        thread2.join();
        System.out.println(System.currentTimeMillis());
    }
}
