package com.webage.testtracker.model;

import java.util.ArrayList;

public class Recommendation {

  private static int   NUMBER_OF_QUESTIONS = 30;
  private static int   POINTS_PER_QUESTION = 10;
  private static float PASSING_PERCENTAGE  = 0.40f;

  private String name;
  private String email;
  private int score;

  private ArrayList<StudyMaterial> studyMaterials = new ArrayList<>();
  private ArrayList<Course> courses = new ArrayList<>();

  public Recommendation(String name, String email, int score) {
    this.name = name;
    this.email = email;
    this.score = score;
  }

  public void addStudyMaterial(StudyMaterial studyMaterial) {
    this.studyMaterials.add(studyMaterial);
  }

  public void addCourse(Course course) {
    this.courses.add(course);
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public int getScore() {
    return score * POINTS_PER_QUESTION;
  }

  public boolean isPassingScore() {
    return score >= (int)(PASSING_PERCENTAGE * NUMBER_OF_QUESTIONS);
  }

  @Override
  public String toString() {

    System.out.println(name + " score: " + score + (isPassingScore()?"PASS":"FAIL"));

    StringBuilder builder = new StringBuilder();

    builder.append("-------------");
    builder.append("\n");
    builder.append(name);
    builder.append(" : ");
    builder.append(email);
    builder.append(" : ");
    builder.append(score * POINTS_PER_QUESTION);
    builder.append(" : ");
    builder.append(isPassingScore()?"PASS":"FAIL");
    builder.append("\n\n");

    if( isPassingScore() ) {
      for (int i = 0; i < studyMaterials.size(); i++) {
        StudyMaterial studyMaterial = studyMaterials.get(i);

        builder.append(studyMaterial != null ? studyMaterial.toString() : "");
        builder.append("\n");

        Course course = courses.get(i);

        builder.append(course != null ? course.toString() : "");
        builder.append("\n");
      }
    }

    return builder.toString();
  }

}
