package com.webage.testtracker.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recommendation {



  private String name;
  private String email;
  private int score;

  private ArrayList<TopicArticleMap.Topic> topics = new ArrayList<>();

  public Recommendation(String name, String email, int score) {
    this.name = name;
    this.email = email;
    this.score = score;
  }

  public void addTopic(TopicArticleMap.Topic topic) {
    topics.add(topic);
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

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("-------------");
    builder.append(System.lineSeparator());
    builder.append(name);
    builder.append(" : ");
    builder.append(email);
    builder.append(" : ");
    builder.append(score);
    builder.append(System.lineSeparator());
    for( TopicArticleMap.Topic topic: topics ) {
      builder.append(topic.toString());
      builder.append(System.lineSeparator());
    }

    return builder.toString();
  }

}
