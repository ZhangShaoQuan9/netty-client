package com.zhang.demo2.config;

import com.zhang.demo2.handler.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class EchoClient {
    private final EventLoopGroup group = new NioEventLoopGroup();
    private Channel channel;

    @Autowired
    private EchoClientHandler clientHandler;

    @PostConstruct
    public void start() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline()
                        .addLast("decoder", new StringDecoder())
                        .addLast("encoder", new StringEncoder())
                        .addLast(clientHandler);
            }
        });

        channel = bootstrap.connect("127.0.0.1", 9876).sync().channel();
    }

    public void send(String message) {
        channel.writeAndFlush(message);
    }

    @PreDestroy
    public void stop() throws InterruptedException {
        channel.close();
        group.shutdownGracefully().sync();
    }
}

