package com.dev.devinspringboot.pattern.creational.builder;

/**
 * 建造者
 */
public abstract class CourseBuilder {
    /*
     private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    private String courseQA; // 问题和答案

     */
    public abstract void buildCourseName(String courseName);
    public abstract void buildCoursePPT(String coursePPT);
    public abstract void buildCourseVideo(String courseVideo);
    public abstract void buildCourseArticle(String courseArticle);
    public abstract void buildCourseQA(String courseQA);

    public abstract Course makeCourse();
}
