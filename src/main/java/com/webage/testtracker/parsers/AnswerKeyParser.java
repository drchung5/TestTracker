package com.webage.testtracker.parsers;

import com.opencsv.CSVReader;
import com.webage.testtracker.model.AnswerKey;
import com.webage.testtracker.model.QuestionCourseMapping;

import java.io.FileReader;

public class AnswerKeyParser {

  public static AnswerKey parseAnswerKey(String path) {

    AnswerKey answerKey = new AnswerKey();

    try (

      CSVReader reader = new CSVReader(new FileReader(path))) {

      String[] row = null;

      while ((row = reader.readNext()) != null) {
        answerKey.addEntry(row[0], row[1]);
      }

    } catch (Exception e) {
        System.out.println(e.toString());
    }

    return answerKey;
  }

}
