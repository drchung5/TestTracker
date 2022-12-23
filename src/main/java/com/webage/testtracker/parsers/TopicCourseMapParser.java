package com.webage.testtracker.parsers;

import com.google.gson.Gson;
import com.webage.testtracker.model.TopicCourseMap;

import java.io.FileReader;
import java.io.Reader;

public class TopicCourseMapParser {

  public static TopicCourseMap parseTopicCourseMap(String path) {

    Gson gson = new Gson();

    TopicCourseMap topicCourseMap = null;

    try( Reader reader = new FileReader(path)) {

      topicCourseMap = gson.fromJson(reader, TopicCourseMap.class);

      System.out.println( "Parsed: " + path );

    } catch ( Exception e ) {
      System.out.println(e.getMessage());
    }

    return topicCourseMap;

  }
}
