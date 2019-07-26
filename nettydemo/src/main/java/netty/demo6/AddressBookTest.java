package netty.demo6;

import netty.demo6.protobuf.model.AddressBookProtos;

/**
 * Created by Lee on 2019-07-26.
 *
 * @author Lee
 */
public class AddressBookTest {

    public static void main(String[] args) throws Exception{

        AddressBookProtos.person person = AddressBookProtos.person.newBuilder()
                .setName("张三")
                .setAge(20)
                .setAddress("湖北省武汉市").build();

        byte[] bytes = person.toByteArray();

        //返序列化还原对象
        AddressBookProtos.person newPerson = AddressBookProtos.person.parseFrom(bytes);

        System.out.println(newPerson.getName());
        System.out.println(newPerson.getAddress());
        System.out.println(newPerson.getAge());
    }

}
