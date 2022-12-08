package com.webage.testtracker.parsers;

import com.opencsv.CSVReader;
import com.webage.testtracker.model.Mappings;
import com.webage.testtracker.model.QuestionCourseMapping;

import java.io.FileReader;
import java.util.Arrays;

public class QuestionCourseMappingsParser {

  public static Mappings ParseResults(String path  ) {

    Mappings mappings = new Mappings();

    try (

      CSVReader reader = new CSVReader(new FileReader(path))) {

      String[] row = null;
      while ((row = reader.readNext()) != null) {

        QuestionCourseMapping mapping = new QuestionCourseMapping();

        mapping.setCourseUrl(row[0]);
        mapping.setCourseTitle(row[1]);

        for( int i = 2; i < row.length; i++ ) {
          if (row[i].length() != 0) {
            mapping.addQuestion(row[i]);
          }
        }

        mappings.addMapping(mapping);
      }

    } catch (Exception e) {
      System.out.println(e.toString());
    }


    return mappings;
  }


}
