package com.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**
 * Created by dengyayun on 17/11/20.
 */
public class myClient implements Runnable {

    public AsynchronousSocketChannel channel;


    public myClient() throws IOException {
        channel = AsynchronousSocketChannel.open();
    }

    private void connect() {
        channel.connect(new InetSocketAddress("127.0.0.1", 8073));
    }


    private void write(String data) throws ExecutionException, InterruptedException {
        channel.write(ByteBuffer.wrap(data.getBytes())).get();
        read();
    }

    private void read() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        channel.read(byteBuffer);

        byteBuffer.flip();

        byte[] bytes =new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);

        String data = new String(bytes).trim();
        System.out.println("客户端收到的返回是 " + data);
    }

    public void run() {

        while(true){

        }

    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        myClient myClient1 = new myClient();

        myClient1.connect();

        new Thread(myClient1).start();

        Thread.sleep(1000);

        myClient1.write("11111111");
    }
}
