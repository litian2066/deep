package com.dev.devinspringboot.netty.ch1;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Slf4j
public class ClientHandler {

    public static final int MAX_DATA_LEN = 1024;

    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    /**
     * 对于每一个客服端都要去创建一个线程?
     * 如果不创建线程,就会导致客服端读写的时候会阻塞while true 以及调用它的线程
     * 导致serverSocket.accept()这个方法永远不会执行
     */
    public void start() {
        log.info("新客服端接入");
        new Thread(() -> {
            doStart();

        }).start();
    }

    private void doStart() {
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                byte[] data = new byte[MAX_DATA_LEN];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    String message = new String(data, 0, len);
                    log.info("客服端传来消息: {}", message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
