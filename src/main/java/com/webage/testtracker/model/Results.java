package com.webage.testtracker.model;

import java.util.ArrayList;

public class Results {

  private ArrayList<String> questions = new ArrayList();
  private ArrayList<Student> students = new ArrayList();

  public Results() {
  }

  public void addQuestion(String question) {
    questions.add(question);
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();

    int count = 1;
    for( String question: questions ) {

      stringBuilder.append( count +") " + question+"\n");
      count++;

    }

    stringBuilder.append("\n-----------------\n");

    students.forEach(student -> stringBuilder.append(student.toString()));

    return stringBuilder.toString();

  }
}
