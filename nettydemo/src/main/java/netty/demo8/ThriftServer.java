package netty.demo8;

import netty.demo8.model.PersonServer;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * Created by Lee on 2019-07-29.
 *
 * @author Lee
 */
public class ThriftServer {

    public static void main(String[] args) throws Exception{

        TNonblockingServerSocket socket = new TNonblockingServerSocket(8090);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);

        PersonServer.Processor<PersonServerImpl> processor = new PersonServer.Processor<>(new PersonServerImpl());
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        TServer server = new THsHaServer(arg);

        System.out.println("服务启动");

        server.serve();

    }

}
