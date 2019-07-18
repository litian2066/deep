package com.dev.devinspringboot.pattern.creational.builder;

public class Tset {

    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);
        Course course = coach.makeCourse("1", "2", "3",
                "4", "5");
        System.out.println(course);
    }
}
