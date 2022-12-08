package com.webage.testtracker.model;

import java.util.ArrayList;

public class Mappings {

  private ArrayList<QuestionCourseMapping> mappings = new ArrayList<>();

  public void addMapping( QuestionCourseMapping mapping ) {
    mappings.add(mapping);
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();

    for( QuestionCourseMapping mapping : mappings ) {

      builder.append("--------------------------\n\n");
      builder.append(mapping);
      builder.append("\n\n");

    }

    return builder.toString();
  }
}
