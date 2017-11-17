package com.thread;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by dengyayun on 17/9/28.
 */
public class SingleThread3 implements Callable<Integer> {

    public Integer call() throws Exception {
        Integer sum=0;
        for(int i = 0; i<5;i++){
            Random r = new Random();

            for (int k=0; k<r.nextInt(10); k++) {
                sum=+k;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
