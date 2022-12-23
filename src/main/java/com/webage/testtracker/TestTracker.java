package com.webage.testtracker;

import com.webage.testtracker.controller.TestController;
import com.webage.testtracker.model.AnswerTopicKey;
import com.webage.testtracker.model.Results;
import com.webage.testtracker.model.TopicArticleMap;
import com.webage.testtracker.model.TopicCourseMap;
import com.webage.testtracker.parsers.AnswerTopicKeyParser;
import com.webage.testtracker.parsers.ResultsParser;
import com.webage.testtracker.parsers.TopicArticleMapParser;
import com.webage.testtracker.parsers.TopicCourseMapParser;
import com.webage.testtracker.ui.UserInterface;

public class TestTracker {

  public static void main(String[] argv ) {

//    new UserInterface();

//    Results results = ResultsParser.ParseResults("../results.csv");
//    AnswerTopicKey answerTopicKey = AnswerTopicKeyParser.parseAnswerTopicKey("../answer-topic-key.csv");
//    TopicCourseMap topicCourseMap = TopicCourseMapParser.parseTopicCourseMap("../topic-course-map.json");
//    TopicArticleMap topicArticleMap = TopicArticleMapParser.parseTopicArticleMap("../topic-article-map.json");

    TestController.processResults(
                          "../results.csv",
                          "../answer-topic-key.csv",
                          "../topic-article-map.json",
                          "../topic-course-map.json");

//    System.out.println(answerTopicKey);
//    System.out.println(results);
//    System.out.println(topicCourseMap);
//    System.out.println(topicArticleMap);


//
//    List<Recommendation> recommendations = ResultsAnalyzer.getRecommendations(results,mappings,answerKey,70);
//
//    System.out.println(results);
//    System.out.println(mappings);
//    System.out.println(answerTopicKey);

//    for( Recommendation recommendation : recommendations ) {
//      System.out.println(recommendation);
//    }

  }

}
