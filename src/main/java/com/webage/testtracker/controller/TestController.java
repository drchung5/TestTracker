package com.webage.testtracker.controller;

import com.webage.testtracker.analyzer.ResultsAnalyzer;
import com.webage.testtracker.model.*;
import com.webage.testtracker.parsers.*;
import com.webage.testtracker.utilities.RecommendationWriter;

import java.util.ArrayList;
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

    List<Recommendation> recommendations = ResultsAnalyzer.getInstance().getRecommendations(
                                                  results,
                                                  answerTopicKey,
                                                  topicArticleMap,
                                                  topicCourseMap);


    RecommendationWriter.write(recommendations);


  }

}
