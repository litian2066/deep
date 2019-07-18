package com.dev.devinspringboot.pattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射测试单例模式
 */
@Slf4j
public class TestRelection {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, IOException, ClassNotFoundException {

        testThreadLocal();

    }
    /***
     *  由于静态内部类模式以及饿汉模式都是类加载的时候就已经加载完成的所以使用反射只要在构造函数判断一下就可以了
     *  然而懒汉式的话是延迟加载 如果是反射先调用 就不会出问题 无论怎么定义变量判断 反射都可以处理 所以是没有办法的
     *  这儿就需要单例模式的另一种天然对序列化和反序列化以及反射友好的模式 枚举
     *
     */


    // 测试静态内部类模式
    public static void testStaticMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = StaticInnerClassSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) constructor.newInstance();
        System.out.println(instance == newInstance);
    }

    // 测试饿汉单例模式
    public static void testHungryMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = HungrySingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();
        System.out.println(instance == newInstance);
    }

    public static void testEnumMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = EmunSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        EmunSingleton newInstance = (EmunSingleton) constructor.newInstance();
        EmunSingleton instance = EmunSingleton.getInstance();
        System.out.println(newInstance);
        System.out.println(instance);
        System.out.println(instance == newInstance);
    }

    public static void testEnumMethod1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = EmunSingleton1.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        EmunSingleton1 newInstance = (EmunSingleton1) constructor.newInstance();
        EmunSingleton1 instance = EmunSingleton1.getInstance();
        System.out.println(newInstance.getData());
        System.out.println(instance.getData());
        // System.out.println(instance == newInstance);
    }

    public static void testWirte() throws IOException, ClassNotFoundException {
        EmunSingleton1 instance = EmunSingleton1.getInstance();
        ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream(new File("file")));
        oos.writeObject(instance);

        File file = new File("file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        EmunSingleton1 hungrySingleton1= (EmunSingleton1) ois.readObject();
        System.out.println(instance);
        System.out.println(hungrySingleton1);
        System.out.println(instance == hungrySingleton1);
    }

    public static void testThreadLocal() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ThreadLocalSingleton threadLocalSingleton = ThreadLocalSingleton.getInstance();
                // log.info("{}, {}", Thread.currentThread().getName(), threadLocalSingleton);
                System.out.println(Thread.currentThread().getName() + "---" + threadLocalSingleton);
            }).start();
        }
    }
}
