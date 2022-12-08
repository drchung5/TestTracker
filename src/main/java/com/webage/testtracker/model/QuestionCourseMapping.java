package com.webage.testtracker.model;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionCourseMapping {

  private String courseUrl;
  private String courseTitle;
  private ArrayList<String> questions = new ArrayList<>();

  public QuestionCourseMapping() {
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();

    builder.append(courseTitle+"\n");
    builder.append(courseUrl+"\n");

    for( String question: questions ) {
      builder.append("- "+question+"\n");
    }

    return builder.toString();

  }

  public String getCourseUrl() {
    return courseUrl;
  }

  public void setCourseUrl(String courseUrl) {
    this.courseUrl = courseUrl;
  }

  public String getCourseTitle() {
    return courseTitle;
  }

  public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
  }

  public ArrayList<String> getQuestions() {
    return questions;
  }

  public void addQuestion(String question) {
    this.questions.add(question);
  }
}
