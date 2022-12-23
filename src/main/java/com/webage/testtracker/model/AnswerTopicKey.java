package com.webage.testtracker.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AnswerTopicKey {

  private Set<Integer> topicSet = new HashSet<>();


  public int getTopicCount() {
    return topicSet.size();
  }

  private ArrayList<AnswerTopic> keyTopicList = new ArrayList<>();

  public void add(AnswerTopic answerTopic) {
    keyTopicList.add(answerTopic);
  }

  public int getTopic(int questionNumber) {
    return keyTopicList.get(questionNumber).getTopic();
  }

  public String getAnswer(int questionNumber) {
    return keyTopicList.get(questionNumber).getAnswer();
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();

    builder.append("Topic Count: ");
    builder.append(getTopicCount());

    builder.append("\n----------------\n\n");

    for(int i = 0; i < keyTopicList.size(); i++ ) {
      AnswerTopic answerTopic = keyTopicList.get(i);
      builder.append(String.format("%-2s) %-2d %s\n",
                                          i+1,
                                          answerTopic.getTopic(),
                                          answerTopic.getAnswer()));
    }

    return builder.toString();
  }
}
