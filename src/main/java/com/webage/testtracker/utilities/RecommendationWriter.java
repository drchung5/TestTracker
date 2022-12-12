package com.webage.testtracker.utilities;

import com.webage.testtracker.model.Recommendation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RecommendationWriter {

  public static void write( List<Recommendation> recommendations ) {

    File outputFile = new File("recomendations.txt");
    try(FileWriter writer = new FileWriter(outputFile,true)) {

      for( Recommendation recommendation : recommendations ) {
        writer.write(recommendation.toString());
      }

    } catch ( IOException e ) {
      System.out.println( e.getMessage() );
    }

  }

}
