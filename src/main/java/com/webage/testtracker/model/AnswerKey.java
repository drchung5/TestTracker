package com.webage.testtracker.model;

import java.util.HashMap;
import java.util.Map;

public class AnswerKey {

  Map<String,String> keys = new HashMap<>();

  public void addEntry(String question, String answer) {
    keys.put(question,answer);
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();

    builder.append("\n----------------\n\n");

    for(Map.Entry<String,String> entry: keys.entrySet()) {
      builder.append(String.format("%-2s %s\n", entry.getValue(), entry.getKey()));
    }
    return builder.toString();
  }
}
