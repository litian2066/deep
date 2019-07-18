package com.dev.devinspringboot.pattern.creational.singleton;

/**
 * 懒汉式
 * 首先是很懒的 在初始化的时候是没有创建的 而是做一个延迟加载
 */
public class LazyDoubleCheckSingleton {

    // 加入volatile防止指令重排序
    private volatile static LazyDoubleCheckSingleton lazySingleton = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySingleton;
    }
}
