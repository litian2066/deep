package com.dev.devinspringboot.netty.ch1;

/**
 * 使用socket实现传统通信
 */
public class ServerBoot {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}
