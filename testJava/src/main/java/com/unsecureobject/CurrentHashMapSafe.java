package com.unsecureobject;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by dengyayun on 17/9/13.
 */
public class CurrentHashMapSafe {
    public static void main(String[] args) throws InterruptedException {

        for(int counter =0; counter<1000;counter++) {

//            final <String, String> firstHashMap=new <String, String>();
//            final int end1 = 100;
//            int step = 200;
//            final int end2 = end1 + step;
//            //线程一
//            Thread t1=new Thread(){
//                public void run() {
//                    for(int i=0;i<end1;i++){
//                        firstHashMap.put(String.valueOf(i), String.valueOf(i));
//                    }
//                }
//            };
//
//            Thread t2=new Thread(){
//                public void run() {
//                    for(int j=end1;j<end2;j++){
//                        firstHashMap.put(String.valueOf(j), String.valueOf(j));
//                    }
//                }
//            };
//
//            t1.start();
//            t2.start();
//
//            //主线程休眠1秒钟，以便t1和t2两个线程将firstHashMap填装完毕。
////            Thread.currentThread().sleep(5000);
//            t1.join();
//            t2.join();
//
//            for(int l=0;l<end2;l++){
//                //如果key和value不同，说明在两个线程put的过程中出现异常。
//                if(!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))){
//                    System.out.println("error ,the counter is " + counter + " the key is " + l + " the value is " + firstHashMap.get(String.valueOf(l)));
//                    System.err.println(String.valueOf(l)+":"+firstHashMap.get(String.valueOf(l)));
//                }
//            }
        }

    }
}
