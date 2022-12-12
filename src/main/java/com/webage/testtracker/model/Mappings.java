package com.webage.testtracker.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mappings {

  private Map<String,Course> courseMappings = new HashMap<>();

  public void addMapping( String question, Course course ) {
    courseMappings.put(question,course);
  }

  public Course getCourse(String question) {
    return courseMappings.get(question);
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();

    builder.append("\n----------------\n\n");

    for(Map.Entry<String,Course> entry: courseMappings.entrySet()) {
      builder.append(String.format(
          "%-20s %-20s  %s\n",
          entry.getValue().getCourseTitle(),
          entry.getValue().getCourseUrl(),
          entry.getKey()));
    }

    return builder.toString();
  }
}
