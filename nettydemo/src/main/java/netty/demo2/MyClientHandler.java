package netty.demo2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * Created by Lee on 2019-07-19.
 *
 * @author Lee
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {

    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client out:" + msg);
        ctx.channel().writeAndFlush("from client:" + LocalDateTime.now());
    }
}
