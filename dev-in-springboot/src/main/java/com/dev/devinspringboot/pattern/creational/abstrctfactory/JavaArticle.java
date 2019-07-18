package com.dev.devinspringboot.pattern.creational.abstrctfactory;

public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("创建JavaArticle");
    }
}
