package com.webage.testtracker.utilities;

import com.webage.testtracker.model.Recommendation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class RecommendationWriter {

  public static void write( List<Recommendation> recommendations ) {

    String fileName = LocalDateTime.now()+"recomendations.txt";

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
