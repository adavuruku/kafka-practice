package com.example.testconsumer.dto;

public class Course {
    private String courseTitle;
    private String courseCode;
    private int courseUnit;

    public Course() {
    }

    public Course(String courseTitle, String courseCode, int courseUnit) {
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.courseUnit = courseUnit;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(int courseUnit) {
        this.courseUnit = courseUnit;
    }
}
