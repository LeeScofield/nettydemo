package netty.demo7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.demo7.protobuf.model.MyDataInfo;

/**
 * Created by Lee on 2019-07-26.
 *
 * @author Lee
 */
public class ProtobufServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Message> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Message msg) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
