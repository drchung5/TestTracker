package com.webage.testtracker.parsers;

import com.google.gson.Gson;
import com.webage.testtracker.model.TopicArticleMap;
import com.webage.testtracker.model.TopicCourseMap;

import java.io.FileReader;
import java.io.Reader;

public class TopicArticleMapParser {

  public static TopicArticleMap parseTopicArticleMap(String path) {

    Gson gson = new Gson();

    TopicArticleMap topicArticleMap = null;

    try( Reader reader = new FileReader(path)) {

      topicArticleMap = gson.fromJson(reader, TopicArticleMap.class);

      System.out.println( "Parsed: " + path );

    } catch ( Exception e ) {
      System.out.println(e.getMessage());
    }

    return topicArticleMap;

  }

}
