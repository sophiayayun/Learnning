package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;


/**
 * Created by dengyayun on 17/11/20.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {


    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {

        ByteBuf buf = (ByteBuf)msg;
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);

        try {
            String request = new String(data,"utf-8");
            System.out.println("Server: "+ request);

            //写给客户端
            String response ="我是反馈信息";
            ctx.writeAndFlush(Unpooled.copiedBuffer("888".getBytes()));
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
