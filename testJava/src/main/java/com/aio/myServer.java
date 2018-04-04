package com.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dengyayun on 17/11/20.
 */
public class myServer {

    public ExecutorService executorService;

    public AsynchronousServerSocketChannel serverSocketChannel;

    public AsynchronousChannelGroup group;

    public myServer(int port) {

        try {
            executorService = Executors.newCachedThreadPool();
            group = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);

            serverSocketChannel = AsynchronousServerSocketChannel.open(group);

            serverSocketChannel.bind(new InetSocketAddress(port));

            System.out.println("server start, port：" + port);

            serverSocketChannel.accept(this, new myServerCompletionHandler());

            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new myServer(8073);
    }
}
