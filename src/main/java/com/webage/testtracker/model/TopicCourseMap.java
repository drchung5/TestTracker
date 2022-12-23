package com.webage.testtracker.model;

import java.util.ArrayList;

public class TopicCourseMap {

  public static class Module {
    public String name;
    public String url;
    public String duration;

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append( "\t" );
      stringBuilder.append( name );
      if( duration != null ) {
        stringBuilder.append( " ("+duration+")");
      }
      stringBuilder.append("\n\t");
      stringBuilder.append(url);
      stringBuilder.append("\n");

      return stringBuilder.toString();
    }
  }

  public static class Topic {
    public int[] topics;
    public String name;
    public String url;
    public ArrayList<Module> modules;

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");

      for( int i = 0; i < topics.length; i++ ) {
        stringBuilder.append(topics[i]);
      }

      stringBuilder.append("] ");
      stringBuilder.append(name);
      stringBuilder.append("\n");
      stringBuilder.append(url);
      stringBuilder.append("\n");

      for( Module module : modules ) {
        stringBuilder.append(module.toString());
      }

      stringBuilder.append("\n");
      return stringBuilder.toString();
    }
  }

  public ArrayList<Topic> topics = new ArrayList<>();

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();

    for( Topic topic : topics) {
      stringBuilder.append(topic);
    }

    return stringBuilder.toString();
  }
}

