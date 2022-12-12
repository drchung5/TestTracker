package com.webage.testtracker;

import com.webage.testtracker.analyzer.ResultsAnalyzer;
import com.webage.testtracker.model.AnswerKey;
import com.webage.testtracker.model.Mappings;
import com.webage.testtracker.model.Recommendation;
import com.webage.testtracker.model.Results;
import com.webage.testtracker.parsers.AnswerKeyParser;
import com.webage.testtracker.parsers.QuestionCourseMappingsParser;
import com.webage.testtracker.parsers.ResultsParser;
import com.webage.testtracker.ui.UserInterface;

import java.util.List;

public class TestTracker {

  public static void main(String[] argv ) {

    new UserInterface();

//    Results results = ResultsParser.ParseResults("../results.csv");
//
//    Mappings mappings = QuestionCourseMappingsParser.ParseResults("../question-course-map.csv");
//
//    AnswerKey answerKey = AnswerKeyParser.parseAnswerKey("../answer-key.csv");
//
//    List<Recommendation> recommendations = ResultsAnalyzer.getRecommendations(results,mappings,answerKey,70);
//
////    System.out.println(results);
////    System.out.println(mappings);
////    System.out.println(answerKey);
//
//    for( Recommendation recommendation : recommendations ) {
//      System.out.println(recommendation);
//    }

  }

}
