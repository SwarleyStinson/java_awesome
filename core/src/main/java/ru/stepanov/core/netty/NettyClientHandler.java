package ru.stepanov.core.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg;
        try {
            int length = ((ByteBuf) msg).readableBytes();
            ByteBuf readBytes = ((ByteBuf) msg).readBytes(length);
            CharSequence chars = readBytes.getCharSequence(0, length, Charset.defaultCharset());
            String serverMessage = chars.toString();

            System.out.println(serverMessage);
        } finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
