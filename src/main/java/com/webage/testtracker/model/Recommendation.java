package com.webage.testtracker.model;

import java.util.ArrayList;

public class Recommendation {

  private String name;
  private int score;
  private ArrayList<Integer> missedQuestions = new ArrayList<>();
  private ArrayList<Integer> courses = new ArrayList<>();

  public Recommendation( String name,
                         int score,
                         ArrayList<Integer> missedQuestions,
                         ArrayList<Integer> courses) {
    this.name = name;
    this.score = score;
    this.missedQuestions = missedQuestions;
    this.courses = courses;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public ArrayList<Integer> getMissedQuestions() {
    return missedQuestions;
  }

  public ArrayList<Integer> getCourses() {
    return courses;
  }
}
