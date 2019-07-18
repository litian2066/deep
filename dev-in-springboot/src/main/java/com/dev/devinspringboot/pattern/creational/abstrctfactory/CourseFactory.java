package com.dev.devinspringboot.pattern.creational.abstrctfactory;

/**
 * 课程抽象工厂类
 */
public interface CourseFactory {

    Video getVideo();
    Article getArticle();
}
