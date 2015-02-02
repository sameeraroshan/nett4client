
import initializer.ClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by roshans on 1/27/2015.
 */
public class Client implements Runnable{
    private final String host;
    private final int port;
    private Channel channel;
    private EventLoopGroup eventLoopGroup;

    public static void main(String[] args){
        Client client = new Client("localhost",5000);
        client.connect();
        new Thread(new Client("localhost",5000)).start();
    }

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        connect();
    }

    public void connect() {
        eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ClientInitializer());

        try {
            channel = bootstrap.connect(host, port).sync().channel();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }

    }

    public void closeConnection(){
        try {
            channel.close();
            eventLoopGroup.shutdownGracefully();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                //channel.write(reader.readLine());
                channel.write("hi im "+channel.localAddress()+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
