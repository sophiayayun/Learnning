package com.thread;

/**
 * Created by dengyayun on 17/5/17.
 */
public class MySignal {
    protected boolean hasDataToProcess = false;

    public synchronized  boolean hasDataToProcess () throws InterruptedException {
        for(int i=0; i<500000;i++){
            Thread.sleep(10000);
        }
        return this.hasDataToProcess;
    }

    public synchronized void writeData(boolean hasData) {
        this.hasDataToProcess = hasData;
    }


    public static void main(String[] args) {
        final MySignal mySignal = new MySignal();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    mySignal.hasDataToProcess();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                mySignal.writeData(true);
            }
        });

        thread1.start();
        thread2.start();
    }
}
