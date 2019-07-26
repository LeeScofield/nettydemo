package netty.demo7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.demo7.protobuf.model.MyDataInfo;

import java.util.Random;

/**
 * Created by Lee on 2019-07-26.
 *
 * @author Lee
 */
public class ProtobufClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Message> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Message msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int random = new Random().nextInt(3); //生成3以内随机数，随机发送消息类型

        MyDataInfo.Message message = null;

        if (random == 0) {
            message = MyDataInfo.Message.newBuilder().setAnimalType(MyDataInfo.Message.AnimalType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder().setName("小狗").setFood("骨头"))
                    .build();
        } else if (random == 1) {
            message = MyDataInfo.Message.newBuilder().setAnimalType(MyDataInfo.Message.AnimalType.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder().setName("小猫").setAge(3))
                    .build();
        } else if (random == 2) {
            message = MyDataInfo.Message.newBuilder().setAnimalType(MyDataInfo.Message.AnimalType.RabbitType)
                    .setRabbit(MyDataInfo.Rabbit.newBuilder().setName("小兔子").setHome("免子的窝"))
                    .build();
        }

        ctx.writeAndFlush(message);
    }
}
