package com.threadPool;

import java.util.concurrent.Callable;

/**
 * Created by dengyayun on 17/6/15.
 */
public class MyTaskCallable implements Callable<Object> {

    private int taskNum;

    public MyTaskCallable(int taskNum) {
        this.taskNum = taskNum;
    }

    public Object call() throws Exception {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
        return "call()方法被自动调用，任务的结果是：" + taskNum + "    " + Thread.currentThread().getName();
    }
}
