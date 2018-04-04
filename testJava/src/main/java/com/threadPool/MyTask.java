package com.threadPool;

/**
 * Created by dengyayun on 17/6/6.
 */
public class MyTask implements Runnable{

    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(400);
            if(taskNum ==80) {
                Thread.currentThread().sleep(40);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }

//    public int compareTo(MyTask myTask) {
//        return this.taskNum > myTask.taskNum? 1:0;
//    }
}
