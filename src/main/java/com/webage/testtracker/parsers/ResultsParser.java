package com.webage.testtracker.parsers;

import com.opencsv.CSVReader;
import com.webage.testtracker.model.Results;
import com.webage.testtracker.model.Student;

import java.io.FileReader;
import java.util.Arrays;

public class ResultsParser {

  public static Results ParseResults( String path  ) {

    Results results = new Results();

    try (CSVReader reader = new CSVReader(new FileReader( path ))) {

      {
        String[] questions = reader.readNext();
        for( int i = 3; i < questions.length; i++ ) {
          results.addQuestion(questions[i]);
        }
      }

      {
        String[] row = null;
        while ((row = reader.readNext()) != null) {

          Student student = new Student();

          student.setName(row[0]);
          student.setEmail(row[1]);
          student.setScore(Integer.parseInt(row[2]));
          student.setAnswers(Arrays.copyOfRange(row, 3, row.length-1));

          results.addStudent(student);
        }
      }

    } catch ( Exception e ) {
      System.out.println( e.toString() );
    }


    return results;
  }

}
