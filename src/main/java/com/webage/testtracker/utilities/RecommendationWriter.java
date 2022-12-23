package com.webage.testtracker.utilities;

import com.webage.testtracker.model.Recommendation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class RecommendationWriter {

  public static void write( List<Recommendation> recommendations ) {

    LocalDateTime now = LocalDateTime.now();
    String datetime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-", Locale.ENGLISH));


    String fileName = datetime +"recomendations.txt";

    File outputFile = new File(fileName);
    System.out.println("Recommendation File: " + outputFile.getAbsolutePath());
    try(FileWriter writer = new FileWriter(outputFile, false)) {

      for( Recommendation recommendation : recommendations ) {
        writer.write(recommendation.toString());
      }

    } catch ( IOException e ) {
      System.out.println( e.getMessage() );
    }

  }

}
