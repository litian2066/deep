package com.dev.devinspringboot.pattern.creational.abstrctfactory;

/**
 * Python产品族
 */
public class PythonCourseFactory implements CourseFactory{
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
