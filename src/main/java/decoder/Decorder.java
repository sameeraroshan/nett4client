package decoder;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by roshans on 1/28/2015.
 */
public class Decorder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {

        StringBuilder sb = new StringBuilder();

        while (buffer.readableBytes()>0){
            sb.append((char)buffer.readByte());
        }
        out.add(sb.toString());
    }
}
