namespace java netty.demo8.thrift.model

typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String


struct Person{
    1:optional String name;
    2:optional int age;
    3:optional boolean married;
}

exception DataException{
    1:optional String msg;
    2:optional String code;
}

service PersonServer{
    Person getPersonByName(1:required String name) throws(1:DataException dataException);
    void savePerson(1:required Person person) throws(1:DataException dataException);
}





