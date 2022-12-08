package com.webage.testtracker;

import com.webage.testtracker.model.AnswerKey;
import com.webage.testtracker.model.Mappings;
import com.webage.testtracker.model.Results;
import com.webage.testtracker.parsers.AnswerKeyParser;
import com.webage.testtracker.parsers.QuestionCourseMappingsParser;
import com.webage.testtracker.parsers.ResultsParser;

public class TestTracker {

  public static void main( String[] argv ) {

    Results results = ResultsParser.ParseResults("../results.csv");

    System.out.println(results);

    Mappings mappings = QuestionCourseMappingsParser.ParseResults("../question-course-map.csv");

    System.out.println(mappings);

    AnswerKey answerKey = AnswerKeyParser.parseAnswerKey("../answer-key.csv");

    System.out.println(answerKey);

  }

}
