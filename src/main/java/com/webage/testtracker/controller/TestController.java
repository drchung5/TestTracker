package com.webage.testtracker.controller;

import com.webage.testtracker.analyzer.ResultsAnalyzer;
import com.webage.testtracker.model.*;
import com.webage.testtracker.parsers.AnswerTopicKeyParser;
import com.webage.testtracker.parsers.ResultsParser;
import com.webage.testtracker.parsers.TopicArticleMapParser;
import com.webage.testtracker.parsers.TopicCourseMapParser;
import com.webage.testtracker.utilities.RecommendationWriter;

import java.util.List;
/*
  class to manage the three main parts of the application

  1. Read and parse the input files
  2. Process the data and produce recommendations
  3. Write the recommendations to a file

*/
public class TestController {

  // It doesn't matter where the paths come from (GUI, command line,
  // hard-coded) this method takes the input file paths and coordinates
  // the processing
  public static void processResults(
                        String resultsFilePath,
                        String answerTopicKeyFilePath,
                        String topicArticleMapFilePath,
                        String topicCourseMapFilePath){

    // parse the 4 files whose paths were passed to this method
    Results results                 = ResultsParser.ParseResults(resultsFilePath);
    AnswerTopicKey answerTopicKey   = AnswerTopicKeyParser.parseAnswerTopicKey(answerTopicKeyFilePath);
    TopicArticleMap topicArticleMap = TopicArticleMapParser.parseTopicArticleMap(topicArticleMapFilePath);
    TopicCourseMap topicCourseMap   = TopicCourseMapParser.parseTopicCourseMap(topicCourseMapFilePath);

    // pass the parsed data to the analyzer
    List<Recommendation> recommendations = ResultsAnalyzer.getInstance().getRecommendations(
                                                  results,
                                                  answerTopicKey,
                                                  topicArticleMap,
                                                  topicCourseMap);

    // Call the RecommendationWrite to write the recommendations to a file
    RecommendationWriter.write(recommendations);


  }

}
