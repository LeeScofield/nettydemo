package netty.demo7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.demo6.protobuf.model.AddressBookProtos;

/**
 * Created by Lee on 2019-07-26.
 *
 * @author Lee
 */
public class ProtobufClientHandler extends SimpleChannelInboundHandler<AddressBookProtos.person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddressBookProtos.person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(233444434);


        AddressBookProtos.person person = AddressBookProtos.person.newBuilder().setAddress("湖北")
                .setAge(33)
                .setName("李四")
                .build();

        ctx.channel().writeAndFlush(person);

    }
}
