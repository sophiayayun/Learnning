package com.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by dengyayun on 17/6/6.
 */

public class ProtoPool {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(300));

//        ExecutorService executorService = new ScheduledThreadPoolExecutor();

        //池子最大可容量 10个线程 + 5个排队等待的, 一旦 超过15个还在申请的话,就会报错:RejectedExecutionException,程序不会停止
        //但是如果有线程已经空闲出来了,就没有关系了.
///     直接excute提交任务,但是无法知道任务是否执行成功

        for (int i = 0; i < 200; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            //你的意思我在这里还可以变化  executor的 coreSzie?
            System.out.println("线程池中线程数目:" + executor.getPoolSize() + " 队列中等待线程的数目: " + executor.getQueue().size()
                    + "  已执行完的任务数: " + executor.getCompletedTaskCount());
        }

        executor.shutdown();
//        System.exit(0);



        //如果任务实现了 callable接口,可以获取任务的执行情况.通过 submit 提交任务,可以获得future信息. future的get方法会阻塞住知道任务完成.get(long timeout, TimeUnit unit)方法则会阻塞一段时间后立即返回，这时有可能任务没有执行完
        //call 还支持异常,对于异常情况处理方式
//        List<Future<?>> resultList = new ArrayList<Future<?>>();
//        for(int i=0; i<10; i++) {
//            MyTaskCallable myTask = new MyTaskCallable(i);
//            Future<?> future = executor.submit(myTask);
//            resultList.add(future);
//        }
//        executor.shutdown();
//
//        for(Future<?> future: resultList) {
//            try {
//                System.out.println("结果输出" + future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    }
}

/** 等待队列的方式有:  ArrayBlockingQueue 数组结构的有界阻塞队列,FIFO;
 *                  LinkedBlockingQueue 链表式的阻塞队列,FIFO,吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列
 *                  SynchronousQueue 没有等待队列的大小,传入的参数是 true or false  不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列
 *                  PriorityBlockingQueue一个具有优先级的无限阻塞队列, 线程数只会等于核心线程数,而队列中等待的线程数最大等于 Queue设置的数目加上max线程数减去核心线程数
 *
 *
 *
 */


