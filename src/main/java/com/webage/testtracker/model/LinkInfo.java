package com.webage.testtracker.model;

public class LinkInfo {
  private String name;
  private String url;
  private String duration;

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\t\t");
    stringBuilder.append(name);
    if (duration != null) {
      stringBuilder.append(" (");
      stringBuilder.append( duration );
      stringBuilder.append(" )");
    }
    stringBuilder.append(" ");
    stringBuilder.append(url);
    stringBuilder.append("\n");

    return stringBuilder.toString();
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

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }
}
