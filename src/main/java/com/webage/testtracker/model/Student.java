package com.webage.testtracker.model;

public class Student {

  private String name;
  private String email;
  private int score;
  private String[] answers;

  public Student() {
  }

  public Student(String name, String email, int score, String[] answers) {
    this.name = name;
    this.email = email;
    this.score = score;
    this.answers = answers;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    String studentInfo = String.format("%-20s  %-30s  %2d   ", name, email, score);

    stringBuilder.append(studentInfo);

    for( String answer : answers ) {
      stringBuilder.append( answer + " " );
    }

    stringBuilder.append("\n");

    return stringBuilder.toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String[] getAnswers() {
    return answers;
  }

  public void setAnswers(String[] answers) {
    this.answers = answers;
  }
}
