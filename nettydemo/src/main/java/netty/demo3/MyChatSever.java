package netty.demo3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Lee
 * date:2019-07-22
 */
public class MyChatSever {

    public static void main(String[] args) throws Exception{

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(ServerSocketChannel.class)
                    .channel(null);

            ChannelFuture channelFuture = bootstrap.bind(8090).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {

            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }

    }

}
