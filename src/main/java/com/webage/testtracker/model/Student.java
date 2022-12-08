package com.webage.testtracker.model;

public class Student {

  private String name;
  private String email;
  private int score;
  private String[] answers = new String[]{};

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

  public String getEmail() {
    return email;
  }

  public int getScore() {
    return score;
  }

  public String[] getAnswers() {
    return answers;
  }

}
