package com.webage.testtracker.model;

public class AnswerTopic {
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
