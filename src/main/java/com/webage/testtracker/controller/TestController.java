package com.webage.testtracker.controller;

import com.webage.testtracker.analyzer.ResultsAnalyzer;
import com.webage.testtracker.model.AnswerKey;
import com.webage.testtracker.model.Mappings;
import com.webage.testtracker.model.Recommendation;
import com.webage.testtracker.model.Results;
import com.webage.testtracker.parsers.AnswerKeyParser;
import com.webage.testtracker.parsers.QuestionCourseMappingsParser;
import com.webage.testtracker.parsers.ResultsParser;
import com.webage.testtracker.utilities.RecommendationWriter;

import java.util.List;

public class TestController {

  public static void processResults(
                        String resultsFilePath,
                        String answerKeyFilePath,
                        String mappingFilePath){

    Results results = ResultsParser.ParseResults(resultsFilePath);

    Mappings mappings = QuestionCourseMappingsParser.ParseResults(mappingFilePath);

    AnswerKey answerKey = AnswerKeyParser.parseAnswerKey(answerKeyFilePath);

    List<Recommendation> recommendations = ResultsAnalyzer.getRecommendations(results,mappings,answerKey,70);

    RecommendationWriter.write(recommendations);

//    System.out.println(results);
//    System.out.println(mappings);
//    System.out.println(answerKey);
//
//    for( Recommendation recommendation : recommendations ) {
//      System.out.println(recommendation);
//    }

  }

}
