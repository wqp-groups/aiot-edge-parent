package com.wqp.aiot.edge.stream.stream.netty;

import com.wqp.common.stream.netty.client.AbstractChannelHandlerClient;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;

public class ChannelHandlerClient extends AbstractChannelHandlerClient {

    @Override
    protected Object receive(ChannelHandlerContext ctx, byte[] bytes) {
        System.out.println("客户端接收到服务端的数据了");
        String content = null;
        try {
            content = new String(bytes, "UTF-8");
            System.out.println(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void channelClose(ChannelHandlerContext ctx) {

    }
}

