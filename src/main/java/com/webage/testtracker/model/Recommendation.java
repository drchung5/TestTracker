package com.webage.testtracker.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recommendation {

  private String name;
  private String email;
  private int score;

  private ArrayList<String> missedQuestions = new ArrayList<>();
  private Set<Course> courses = new HashSet<>();

  public Recommendation( String name,
                         String email,
                         int score) {
    this.name = name;
    this.email = email;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public int getScore() {
    return score;
  }

  public List<String> getMissedQuestions() {
    return missedQuestions;
  }

  public void addMissedQuestion( String missedQuestion ) {
    missedQuestions.add(missedQuestion);
  }

  public List<Course> getCourses() {
    return new ArrayList<>(courses);
  }

  public void addCourse( Course course ) {
    courses.add(course);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("-------------");
    builder.append(System.lineSeparator());
    builder.append(name);
    builder.append(" : ");
    builder.append(email);
    builder.append(" : ");
    builder.append(score);
    builder.append(System.lineSeparator());
    for( Course course: courses ) {
      builder.append(course.toString());
      builder.append(System.lineSeparator());
    }

    return builder.toString();
  }

}
