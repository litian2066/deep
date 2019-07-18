package com.dev.devinspringboot.pattern.creational.abstrctfactory;

/**
 * Java产品族
 */
public class JavaCourseFactory implements CourseFactory{

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
