package com.dev.devinspringboot.netty.ch1;

import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;

/**
 * 客服端
 */
@Slf4j
public class Client {

    private static final String HOST = "127.0.0.1";

    private static final int PORT = 8000;

    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);
        new Thread(() -> {
           log.info("客户端启动成功");
           // 轮询
           while (true) {
               try {
                   String message = "hello world";
                   log.info("客服端发送数据: {}", message);
                   socket.getOutputStream().write(message.getBytes());
               } catch (Exception e) {
                   log.error("写数据出错");
               }
               sleep();
           }
        }).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
