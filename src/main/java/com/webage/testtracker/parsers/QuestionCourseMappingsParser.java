package com.webage.testtracker.parsers;

import com.opencsv.CSVReader;
import com.webage.testtracker.model.Course;
import com.webage.testtracker.model.Mappings;
import com.webage.testtracker.model.QuestionCourseMapping;
import com.webage.testtracker.utilities.ASCIITrim;

import java.io.FileReader;
import java.util.Arrays;

public class QuestionCourseMappingsParser {

  public static Mappings ParseResults(String path  ) {

    Mappings mappings = new Mappings();

    try (

      CSVReader reader = new CSVReader(new FileReader(path))) {

      String[] row = null;
      while ((row = reader.readNext()) != null) {

        // The ASCIITrim.trim() function here is a kludge for some reason
        // when reading the question to course mapping file the first
        // character is ASCII(65279) 'ZERO WIDTH NO-BREAK SPACE'
        // I am not sure why it appears only in this file
        // All of the CSV files are exported directly from Excel and no
        // other file appears to have this problem

        mappings.addMapping(row[2],new Course(ASCIITrim.trim(row[0]),row[1]));
      }

    } catch (Exception e) {
      System.out.println(e.toString());
    }


    return mappings;
  }


}
