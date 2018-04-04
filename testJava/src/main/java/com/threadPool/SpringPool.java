package com.threadPool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by dengyayun on 17/12/19.
 */
public class SpringPool extends ApplicationObjectSupport {

    ApplicationContext context;

    public void initialac(){
//        super.setApplicationContext(context);
//        super.initApplicationContext();
//        context = new ApplicationObjectSupport().;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:config.spring/appcontext-client.xml");

        ThreadPoolTaskExecutor excutor = (ThreadPoolTaskExecutor)ac.getBean("rsReceiptIssueExecutor");

        for(int i=0; i<126; i++){
            MyTask task = new MyTask(i);
            excutor.submit(task);
        }

//        excutor.shutdown();
    }
}
