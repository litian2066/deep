package com.dev.devinspringboot.pattern.creational.singleton;

import java.io.Serializable;

public class HungrySingleton implements Serializable {

    private final static  HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private Object readResolve() {
        return hungrySingleton;
    }
}
