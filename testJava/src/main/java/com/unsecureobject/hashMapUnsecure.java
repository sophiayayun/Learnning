package com.unsecureobject;


import java.util.Hashtable;

import java.util.HashMap;

/**
 * Created by dengyayun on 17/9/13.
 */
public class hashMapUnsecure {

//    public static final HashMap<String, String> firstHashMap=new HashMap<String, String>();

    public static void main(String[] args) throws InterruptedException {

        for(int counter =0; counter<1000;counter++) {

//            final HashMap<String, String> firstHashMap=new HashMap<String, String>();
            final Hashtable<String,String> firstHashMap=new Hashtable();
            final int end1 = 100;
            int step = 200;
            final int end2 = end1 + step;
            //线程一
            Thread t1=new Thread(){
                public void run() {
                    for(int i=0;i<end1;i++){
                        firstHashMap.put(String.valueOf(i), String.valueOf(i));
                    }
                }
            };

            Thread t2=new Thread(){
                public void run() {
                    for(int j=end1;j<end2;j++){
                        firstHashMap.put(String.valueOf(j), String.valueOf(j));
                    }
                }
            };

            t1.start();
            t2.start();

            //主线程休眠1秒钟，以便t1和t2两个线程将firstHashMap填装完毕。
//            Thread.currentThread().sleep(5000);
            t1.join();
            t2.join();

            for(int l=0;l<end2;l++){
                //如果key和value不同，说明在两个线程put的过程中出现异常。
                if(!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))){
                    System.out.println("error ,the counter is " + counter + " the key is " + l + " the value is " + firstHashMap.get(String.valueOf(l)));
                    System.err.println(String.valueOf(l)+":"+firstHashMap.get(String.valueOf(l)));
                }
            }
        }

    }
}

//HashMap初始容量大小为16,当有数据要插入时，都会检查容量有没有超过设定的thredhold，如果超过，需要增大Hash表的尺寸，但是这样一来，整个Hash表里的元素都需要被重算一遍。这叫rehash，这个成本相当的大
// http://www.importnew.com/22011.html
