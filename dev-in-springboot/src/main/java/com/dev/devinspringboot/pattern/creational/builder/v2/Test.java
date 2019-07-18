package com.dev.devinspringboot.pattern.creational.builder.v2;

public class Test {
    public static void main(String[] args) {
        Course course =
                new Course.CourseBuilder().buildCourseName("2")
                        .buildCoursePPT("3").build();
        System.out.println(course);
    }
}
