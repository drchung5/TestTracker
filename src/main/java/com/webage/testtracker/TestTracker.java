package com.webage.testtracker;

import com.webage.testtracker.model.Results;
import com.webage.testtracker.parsers.ResultsParser;

public class TestTracker {

  public static void main( String[] argv ) {

    Results results = ResultsParser.ParseResults("../results.csv");

    System.out.println(results);

  }

}
