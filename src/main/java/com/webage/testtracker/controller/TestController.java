package com.webage.testtracker.controller;

import com.webage.testtracker.analyzer.ResultsAnalyzer;
import com.webage.testtracker.model.*;
import com.webage.testtracker.parsers.*;
import com.webage.testtracker.utilities.RecommendationWriter;

import java.util.List;

public class TestController {

  public static void processResults(
                        String resultsFilePath,
                        String answerTopicKeyFilePath,
                        String topicArticleMapFilePath,
                        String topicCourseMapFilePath){

    Results results                 = ResultsParser.ParseResults(resultsFilePath);
    AnswerTopicKey answerTopicKey   = AnswerTopicKeyParser.parseAnswerTopicKey(answerTopicKeyFilePath);
    TopicArticleMap topicArticleMap = TopicArticleMapParser.parseTopicArticleMap(topicArticleMapFilePath);
    TopicCourseMap topicCourseMap   = TopicCourseMapParser.parseTopicCourseMap(topicCourseMapFilePath);

    ResultsAnalyzer.getInstance().getRecommendations(
                                                  results,
                                                  answerTopicKey,
                                                  topicArticleMap,
                                                  topicCourseMap);


//    List<Recommendation> recommendations = ResultsAnalyzer.getRecommendations(results,mappings, answerTopicKey,70);
//
//    RecommendationWriter.write(recommendations);

//    System.out.println(results);
//    System.out.println(mappings);
//    System.out.println(answerKey);
//
//    for( Recommendation recommendation : recommendations ) {
//      System.out.println(recommendation);
//    }

  }

}
