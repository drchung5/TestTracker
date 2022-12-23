package com.webage.testtracker.parsers;

import com.opencsv.CSVReader;
import com.webage.testtracker.model.AnswerTopicKey;
import com.webage.testtracker.utilities.ASCIITrim;

import java.io.FileReader;

public class AnswerTopicKeyParser {

  public static AnswerTopicKey parseAnswerTopicKey(String path) {

    AnswerTopicKey answerTopicKey = new AnswerTopicKey();

    try (

      CSVReader reader = new CSVReader(new FileReader(path))) {

      String[] row = null;

      while ((row = reader.readNext()) != null) {
          answerTopicKey.addEntry(row[2], new AnswerTopicKey.AnswerTopic(row[1],Integer.valueOf(ASCIITrim.trim(row[0]))));
      }

    } catch (Exception e) {
        System.out.println(e.toString());
    }

    System.out.println( "Parsed: " + path );

    return answerTopicKey;
  }

}
