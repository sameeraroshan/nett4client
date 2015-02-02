package handler;

import io.netty.channel.*;

/**
 * Created by roshans on 1/27/2015.
 */
public class ClientOutboundHandler extends ChannelOutboundHandlerAdapter{
    /**
     * Calls {@link io.netty.channel.ChannelHandlerContext#fireChannelRead(Object)} to forward
     * to the next {@link io.netty.channel.ChannelInboundHandler} in the {@link io.netty.channel.ChannelPipeline}.
     *
     * Sub-classes may override this method to change behavior.
     */
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.writeAndFlush( msg , promise);
    }
}
