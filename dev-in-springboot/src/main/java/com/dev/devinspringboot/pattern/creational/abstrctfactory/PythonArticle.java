package com.dev.devinspringboot.pattern.creational.abstrctfactory;

public class PythonArticle extends Article {
    @Override
    public void produce() {
        System.out.println("创建PythonArticle");
    }
}
