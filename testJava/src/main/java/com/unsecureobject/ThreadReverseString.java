package com.unsecureobject;

/**
 * Created by dengyayun on 17/11/21.
 */
class ThreadReverseString implements Runnable {
    /*
     * 这个类用来完成字符串的反转工作，使用了Runnable接口来实现多线程 times是用来表示循环多少次的
     * 因为懒的再写一个变量所以用了一个Object类型的s，后面再转化
     */
    public Object s = null;
    int times = 200;

    /*
     * 两个构造方法把s传进来
     */
    public ThreadReverseString(StringBuffer s) {
        this.s = s;
    }

    public ThreadReverseString(StringBuilder s) {
        this.s = s;
    }

    /*
     * 复写run方法实现多线程 在我的电脑上大概循环200次可以看到效果了，也许换了电脑就得多试几次或者增加循环次数了
     */
    public void run() {
        for (int i = 0; i <= times; i++) {
            /*
             * 似乎sleep一小段效果会好一些 奇奇怪怪的输出格式只是为了便于比较
             */
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (s instanceof StringBuffer) {
                ((StringBuffer) s).reverse();
                System.out.println("BUFFER->" + s);
            } else if (s instanceof StringBuilder) {
                ((StringBuilder) s).reverse();
                System.out.println("        " + s + "<-builder");
            }
        }
    }
}
/*
 * 最后看一下控制台的输出会发现反转后出现井号和下划线交错的都是StringBuilder的输出
 */

