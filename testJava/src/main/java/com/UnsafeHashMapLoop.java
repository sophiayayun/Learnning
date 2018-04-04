package com;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dengyayun on 18/4/3.
 */
public class UnsafeHashMapLoop {

    public static void main(String[] args){

        final Map<String,String> map = new HashMap<String,String>();
//        final ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String, String>();
        //开启10000个线程，在map里面put值
        for (int i = 0 ; i < 10000 ; i ++){
            new Thread(new Runnable() {
                public void run() {
                    map.put(UUID.randomUUID().toString(),"");
                }
            }).start();
        }
    }
}

