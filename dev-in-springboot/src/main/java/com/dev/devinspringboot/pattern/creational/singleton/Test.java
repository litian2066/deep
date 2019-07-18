package com.dev.devinspringboot.pattern.creational.singleton;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        LazySingleton instance = LazySingleton.getInstance();
//        System.out.println("Program start");
        /*new Thread(() ->{
            test();
        }).start();

        new Thread(() ->{
            test();
        }).start();*/
        // 测试序列化和反序列化对单例模式的破坏
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream(new File("file")));
        oos.writeObject(hungrySingleton);

        File file = new File("file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungrySingleton hungrySingleton1= (HungrySingleton) ois.readObject();
        System.out.println(hungrySingleton);
        System.out.println(hungrySingleton1);
        System.out.println(hungrySingleton == hungrySingleton1);
    }

    static void test() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "--" + lazySingleton);
    }
}
