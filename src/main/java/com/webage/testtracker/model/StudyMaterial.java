package com.webage.testtracker.model;

import java.util.ArrayList;

public class StudyMaterial {
  private int topicNumber;
  private String name;
  private ArrayList<LinkInfo> articles;

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TOPIC: ");
    stringBuilder.append(name);
    stringBuilder.append("\n\n");
    stringBuilder.append("\tARTICLES\n");

    for (LinkInfo article : articles) {
      stringBuilder.append(article.toString());
    }

    stringBuilder.append("\n");
    return stringBuilder.toString();
  }

  public int getTopicNumber() {
    return topicNumber;
  }

  public void setTopicNumber(int topicNumber) {
    this.topicNumber = topicNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<LinkInfo> getArticles() {
    return articles;
  }

  public void setArticles(ArrayList<LinkInfo> articles) {
    this.articles = articles;
  }
}
