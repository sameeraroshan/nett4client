package initializer;

import decoder.Decorder;
import encoder.Encoder;
import handler.ClientInboundHandler;
import handler.ClientOutboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by roshans on 1/27/2015.
 */
public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new Decorder());
        pipeline.addLast(new ClientInboundHandler());
        pipeline.addLast(new Encoder());
        pipeline.addLast(new ClientOutboundHandler());
    }
}
