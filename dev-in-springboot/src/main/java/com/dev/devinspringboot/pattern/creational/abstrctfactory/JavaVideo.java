package com.dev.devinspringboot.pattern.creational.abstrctfactory;

public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("创建JavaVideo");
    }
}
