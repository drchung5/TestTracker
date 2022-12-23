package com.webage.testtracker.model;

import java.util.ArrayList;

public class Course {
  private ArrayList<Integer> topicNumbers = new ArrayList<>();
  private String name;
  private String url;
  private ArrayList<LinkInfo> modules;

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();



    stringBuilder.append("\tCOURSE: ");
    stringBuilder.append(name);
    stringBuilder.append(" ");
    stringBuilder.append(url);
    stringBuilder.append("\n\t\tMODULES\n");

    for (LinkInfo module : modules) {
      stringBuilder.append(module.toString());
    }

    stringBuilder.append("\n");

    return stringBuilder.toString();
  }

  public ArrayList<Integer> getTopicNumbers() {
    return topicNumbers;
  }

  public void setTopicNumbers(ArrayList<Integer> topicNumbers) {
    this.topicNumbers = topicNumbers;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ArrayList<LinkInfo> getModules() {
    return modules;
  }

  public void setModules(ArrayList<LinkInfo> modules) {
    this.modules = modules;
  }
}
