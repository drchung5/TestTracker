package com.webage.testtracker.model;

import java.util.Objects;

public class Course {

  private String courseUrl;
  private String courseTitle;

  public Course(String courseUrl, String courseTitle) {
    this.courseUrl = courseUrl;
    this.courseTitle = courseTitle;
  }

  public String getCourseUrl() {
    return courseUrl;
  }

  public String getCourseTitle() {
    return courseTitle;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(courseUrl);
    builder.append(" -- ");
    builder.append(courseTitle);
    return builder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return courseUrl.equals(course.courseUrl) && courseTitle.equals(course.courseTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseUrl, courseTitle);
  }
}
