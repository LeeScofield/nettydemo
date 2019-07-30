package netty.demo8;

import netty.demo8.model.DataException;
import netty.demo8.model.Person;
import netty.demo8.model.PersonServer;
import org.apache.thrift.TException;

/**
 * Created by Lee on 2019-07-29.
 *
 * @author Lee
 */
public class PersonServerImpl implements PersonServer.Iface {
    @Override
    public Person getPersonByName(String name) throws DataException, TException {
        Person person = new Person();
        if (name.equals("张三")) {
            person.setName("张三");
            person.setAge(18);
            person.setMarried(false);
        }else{
            person.setName("李四");
            person.setAge(36);
            person.setMarried(true);
        }

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("用户保存方法调用");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
