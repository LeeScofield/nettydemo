package netty.demo8;

import netty.demo8.model.Person;
import netty.demo8.model.PersonServer;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by Lee on 2019-07-29.
 *
 * @author Lee
 */
public class ThrftClient {
    public static void main(String[] args) throws Exception{

        TTransport transport = new TFramedTransport(new TSocket("localhost",8090),600);
        TProtocol tProtocol = new TCompactProtocol(transport);

        PersonServer.Client client = new PersonServer.Client(tProtocol);

        transport.open();

        System.out.println("客户端调用  getPersonByName");
        Person person = client.getPersonByName("张三");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
        System.out.println("客户端调用  savePerson");

        Person savePerson = new Person();
        savePerson.setName("王五");
        savePerson.setAge(22);
        savePerson.setMarried(false);
        client.savePerson(savePerson);

        transport.close();

    }
}
