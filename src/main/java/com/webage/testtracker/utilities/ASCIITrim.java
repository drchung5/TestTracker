package com.webage.testtracker.utilities;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.nio.charset.StandardCharsets;

public class ASCIITrim {

  // This function trims 'special' and 'non-printable' characters
  // from a string. It removes all characters except [0-9] both
  // Linux/Mac and Windows may result in special characters and
  // this function works for both OS families
  public static String trim(String text) {

    StringBuilder trimmedText = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
      char currentChar = text.charAt(i);
      if (currentChar >= '0' && currentChar <= '9') {
        trimmedText.append(currentChar);
      }
    }

    return trimmedText.toString();
  }

}
