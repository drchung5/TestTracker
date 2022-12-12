package com.webage.testtracker.utilities;

public class ASCIITrim {

  private static char ASCI_65279 = 65279;

  // This function is to trim ASCI(65279) 'ZERO WIDTH NO-BREAK SPACE'
  // characters from the parsed files
  public static String trim(String string) {
    return string.replace(String.valueOf(ASCI_65279),"");
  }

}

