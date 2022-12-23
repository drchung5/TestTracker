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

    new UserInterface();

//    Results results = ResultsParser.ParseResults("../results.csv");
//    System.out.println(results);

//    AnswerTopicKey answerTopicKey = AnswerTopicKeyParser.parseAnswerTopicKey("../answer-topic-key.csv");
//    System.out.println(answerTopicKey);

//    TopicCourseMap topicCourseMap = TopicCourseMapParser.parseTopicCourseMap("../topic-course-map.json");
//    System.out.println(topicCourseMap);

//    TopicArticleMap topicArticleMap = TopicArticleMapParser.parseTopicArticleMap("../topic-article-map.json");
//    System.out.println(topicArticleMap);

//    TestController.processResults(
//                          "../results.csv",
//                          "../answer-topic-key.csv",
//                          "../topic-article-map.json",
//                          "../topic-course-map.json");


  }

}
