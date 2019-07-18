package com.dev.devinspringboot.netty.ch1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            // 绑定端口
            this.serverSocket = new ServerSocket(port);
            log.info("服务端启动成功, 端口: {}", port);
        } catch (IOException ioException) {
            log.error("服务端启动失败");
        }
    }

    /**
     * 启动服务方法
     * 不希望创建server的程序阻塞外面的serverboot的主线程
     * 所以端口监听放在一个单线程里面的
     */
    public void start() {
        new Thread(() -> {
            doStart();
        }).start();
    }

    private void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException io) {
                log.error("服务端异常");
            }
        }
    }
}
