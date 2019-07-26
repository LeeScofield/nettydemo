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

        MyDataInfo.Message.AnimalType animalType = msg.getAnimalType();

        if (animalType == MyDataInfo.Message.AnimalType.DogType) {
            MyDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getFood());
        } else if(animalType == MyDataInfo.Message.AnimalType.CatType){
            MyDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getAge());
        } else if(animalType == MyDataInfo.Message.AnimalType.RabbitType){
            MyDataInfo.Rabbit rabbit = msg.getRabbit();
            System.out.println(rabbit.getName());
            System.out.println(rabbit.getHome());
        }

        System.out.println("---------------------");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
