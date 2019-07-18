package com.dev.devinspringboot.pattern.creational.singleton;

/**
 * 懒汉式
 * 首先是很懒的 在初始化的时候是没有创建的 而是做一个延迟加载
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
