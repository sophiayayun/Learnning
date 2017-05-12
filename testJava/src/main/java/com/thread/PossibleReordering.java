package com.thread;

/**
 * Created by dengyayun on 17/5/2.
 */
//可以看到重排序的情况
public class PossibleReordering {

    static int x,y,m,n;

    public static void main(String[] args) throws InterruptedException {
//        int count =100000;
        int i =0;
        while(true){
            x=y=m=n=0;

            Thread one = new Thread(new Runnable() {
                public void run() {
                    m=1;
                    x=n;
                }
            });

            Thread two = new Thread(new Runnable() {
                public void run() {
                    n=1;
                    y=m;
                }
            });

            //启动并等待线程执行结束
            one.start();
            two.start();
            one.join();
            two.join();

            //输出结果
            System.out.println("index:" + i + " {x:" + x+",y:"+y+"}");

            i++;

            if(x==0 && y==0) break;

        }
    }

}
