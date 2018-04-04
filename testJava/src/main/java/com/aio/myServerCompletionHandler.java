package com.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * Created by dengyayun on 17/11/20.
 */
public class myServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,  myServer> {

    public void completed(AsynchronousSocketChannel channel, myServer attachment) {

        attachment.serverSocketChannel.accept(attachment, this);
        read(channel);

    }

    private void read(final AsynchronousSocketChannel channel) {
        final ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {

            public void completed(Integer resultSize, ByteBuffer attachment) {
                attachment.flip();
                System.out.println("myServer 收到了客户端的请求,长度为:" + resultSize);

                String data = new String(buffer.array()).trim();
                System.out.println("myServer 收到了客户端的请求, 具体值为:" + data);

                String response = "myserver服务器端响应了客户端。。。。。。";
                write(channel, response);
            }

            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    private void write(AsynchronousSocketChannel channel, String response) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(response.getBytes());
        buffer.flip();

        try {
            channel.write(buffer).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void failed(Throwable exc, myServer attachment) {
        exc.printStackTrace();
    }
}
