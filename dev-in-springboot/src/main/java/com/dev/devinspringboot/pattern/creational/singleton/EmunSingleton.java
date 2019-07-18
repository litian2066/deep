package com.dev.devinspringboot.pattern.creational.singleton;

/**
 * 通过枚举的方式创建单例模式
 */
public class EmunSingleton {

    private EmunSingleton() {
//        if ( Sigleton.INSTANCE.getInstance() != null) {
//            throw new RuntimeException("不能被初始化");
//        }
    }

    enum Sigleton {
        INSTANCE;
        private EmunSingleton emunSingleton;
        // JVM保证只被调用一次 在类被调用时被初始化
        Sigleton() {
            if (emunSingleton != null) {
                throw new RuntimeException("不能被初始化");
            }
            emunSingleton = new EmunSingleton();
        }
        public EmunSingleton getInstance() {
            return emunSingleton;
        }
    }

    public static EmunSingleton getInstance() {
        return Sigleton.INSTANCE.getInstance();
    }
}
