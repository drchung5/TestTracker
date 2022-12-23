package com.webage.testtracker.model;

import java.util.ArrayList;

public class TopicArticleMap {

  public static class Article {
    private String name;
    private String url;
    private String duration;

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append( name );
      if( duration != null ) {
        stringBuilder.append( " ("+duration+")");
      }
      stringBuilder.append("\n");
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

  public static class Topic {
    private int number;
    private String name;
    private ArrayList<Article> articles;

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("TOPIC: ");
      stringBuilder.append(name);
      stringBuilder.append("\n");

      for( Article article : articles ) {
        stringBuilder.append(article.toString());
      }

      stringBuilder.append("\n");
      return stringBuilder.toString();
    }

    public int getNumber() {
      return number;
    }

    public void setNumber(int number) {
      this.number = number;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public ArrayList<Article> getArticles() {
      return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
      this.articles = articles;
    }
  }

  public ArrayList<Topic> topics = new ArrayList<>();

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for( Topic topic : topics ) {
      stringBuilder.append(topic);
    }
    return stringBuilder.toString();
  }
}