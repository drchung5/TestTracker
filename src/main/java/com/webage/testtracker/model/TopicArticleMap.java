package com.webage.testtracker.model;

import java.util.ArrayList;

public class TopicArticleMap {

  public ArrayList<StudyMaterial> studyMaterials = new ArrayList<>();

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for( StudyMaterial studyMaterial : this.studyMaterials) {
      stringBuilder.append(studyMaterial);
    }
    return stringBuilder.toString();
  }
}