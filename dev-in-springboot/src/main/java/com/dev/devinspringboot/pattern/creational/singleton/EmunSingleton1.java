package com.dev.devinspringboot.pattern.creational.singleton;

public enum EmunSingleton1 {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EmunSingleton1 getInstance() {
        return INSTANCE;
    }
}
