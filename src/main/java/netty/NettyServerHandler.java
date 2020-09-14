package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        int length = in.readableBytes();
        if (length < 4) {
            return;
        }

        ByteBuf req = in.readBytes(length);
        CharSequence sequence = req.getCharSequence(0, length, Charset.defaultCharset());
        String name = sequence.toString();

        if (name.equals("\r\n")) {
            ByteBuf res = ctx.alloc().buffer();
            res.writeBytes(("Hello, " + name).getBytes());
            ctx.writeAndFlush(res);
        }
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        final ByteBuf response = ctx.alloc().buffer(40);
        response.writeBytes("Hello World!\n".getBytes());

        final ChannelFuture f = ctx.writeAndFlush(response);
//        f.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                assert f == future;
//                ctx.close();
//            }
//        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
