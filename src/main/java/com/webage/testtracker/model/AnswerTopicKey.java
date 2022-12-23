package com.webage.testtracker.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnswerTopicKey {

  public static class AnswerTopic {
    private String answer;
    private int topic;

    public AnswerTopic(String answer, int topic) {
      this.answer = answer;
      this.topic = topic;
    }

    public String getAnswer() {
      return answer;
    }

    public void setAnswer(String answer) {
      this.answer = answer;
    }

    public int getTopic() {
      return topic;
    }

    public void setTopic(int topic) {
      this.topic = topic;
    }
  }

  private Set<Integer> topicSet = new HashSet<>();

  private Map<String,AnswerTopic> keys = new HashMap<>();

  public int getTopicCount() {
    return topicSet.size();
  }

  public void addEntry(String question, AnswerTopic answerTopic) {
    keys.put(question,answerTopic);
    topicSet.add(answerTopic.topic);
  }

  public Map<String,AnswerTopic> getKeys() {
    return keys;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();

    builder.append("Topic Count: ");
    builder.append(getTopicCount());

    builder.append("\n----------------\n\n");

    for(Map.Entry<String,AnswerTopic> entry: keys.entrySet()) {
      builder.append(String.format("%-2s %-2d %s\n",
          entry.getValue().answer, entry.getValue().topic, entry.getKey()));
    }

    return builder.toString();
  }
}
