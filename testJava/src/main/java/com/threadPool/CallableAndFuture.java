package com.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by dengyayun on 17/10/10.
 */
public class CallableAndFuture {

    public static void main(String[] args) {

        ExecutorService executor = new ThreadPoolExecutor(10,10,200, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(true));

        //如果任务实现了 callable接口,可以获取任务的执行情况.通过 submit 提交任务,可以获得future信息. future的get方法会阻塞住知道任务完成.get(long timeout, TimeUnit unit)方法则会阻塞一段时间后立即返回，这时有可能任务没有执行完
        //call 还支持异常,对于异常情况处理方式
        List<Future<?>> resultList = new ArrayList<Future<?>>();
        for(int i=0; i<10; i++) {
            MyTaskCallable myTask = new MyTaskCallable(i);
            Future<?> future = executor.submit(myTask);
            resultList.add(future);
        }
        executor.shutdown();

        for(Future<?> future: resultList) {
            try {
                System.out.println("结果输出" + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
