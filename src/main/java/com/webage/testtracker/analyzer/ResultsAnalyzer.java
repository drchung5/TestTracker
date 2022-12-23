package com.webage.testtracker.analyzer;

import com.webage.testtracker.model.*;

import java.util.*;

public class ResultsAnalyzer {

  private static int POINTS_PER_ITEM = 10;
  private static int TOPIC_THRESHOLD = 2;

  private static ResultsAnalyzer INSTANCE;

  public static ResultsAnalyzer getInstance() {
    if(INSTANCE == null ) {
      INSTANCE = new ResultsAnalyzer();
    }
    return INSTANCE;
  }

  private Results         results;
  private AnswerTopicKey  answerTopicKey;
  private TopicArticleMap topicArticleMap;
  private TopicCourseMap  topicCourseMap;

  public List<Recommendation> getRecommendations(
                                    Results results,
                                    AnswerTopicKey answerTopicKey,
                                    TopicArticleMap topicArticleMap,
                                    TopicCourseMap topicCourseMap) {

    List<Recommendation> recommendations = new ArrayList<>();

    this.results = results;
    this.answerTopicKey = answerTopicKey;
    this.topicArticleMap = topicArticleMap;
    this.topicCourseMap = topicCourseMap;

    for( Student student: results.getStudents() ) {
      int[] scores = calculateScores(student);
      Recommendation recommendation = new Recommendation(
                                            student.getName(),
                                            student.getEmail(),
                                            scores[0] * POINTS_PER_ITEM);

      for(int i = 1; i < scores.length; i++) {
        if(scores[i] < TOPIC_THRESHOLD) {

          // in these two lines of code studyMaterials.get() is List.get() and is zero-based
          // topicCourseMap.getCourse() is a custom method and is one-based
          recommendation.addStudyMaterial(topicArticleMap.studyMaterials.get(i-1));
          recommendation.addCourse(topicCourseMap.getCourse(i));

        }
      }

      recommendations.add(recommendation);

    }

    return recommendations;
  }

  // calculate score and topic scores
  private int[] calculateScores(Student student) {

    List<String> questions = results.getQuestions();
    List<String> answers   = student.getAnswers();
    Map<String, AnswerTopicKey.AnswerTopic> keys = answerTopicKey.getKeys();

    // TODO: we are assuming that there are 10 topics and that it takes 2/3 to pass a topic
    // topics[0] is the total correct answers answers topics[1]-topics[10]
    // are the number right per topic (not zero-based)
    int[] scores = new int[11];

    for( int i = 0; i < answers.size(); i++ ) {

      String answer   = answers.get(i);
      String question = questions.get(i);

      // ignore NAs
      if( !answer.equalsIgnoreCase("NA") ) {

        // get the answer
        String correctAnswer = keys.get(question).getAnswer();

        // get the topic
        int topic = keys.get(question).getTopic();

        // check the answer
        if( answer.equalsIgnoreCase(correctAnswer) ) {
          scores[topic]++; // increment topic score
          scores[0]++;     // increment total score
        }
      }

    }

    return scores;

  }


//    // ordered list of questions (full text)
//    List<String> questions = results.getQuestions();
//
//    // map of question => answer
//    Map<String, AnswerTopicKey.AnswerTopic> keys = answerTopicKey.getKeys();
//
//    ArrayList<Recommendation> recommendations = new ArrayList<>();
//
//
//    // iterate through students
//    for(Student student: results.getStudents()) {
//
//      // check scores
//      if( student.getScore() <= threshold ) {
//
//        Recommendation recommendation = new Recommendation(
//                                                    student.getName(),
//                                                    student.getEmail(),
//                                                    student.getScore()
//                                                );
//
//        ArrayList<String> missedQuestions = new ArrayList<>();
//        Set<Course> courses = new HashSet<>();
//
//
//        // get an iterator for the answers and for the questions
//        // will iterate through them together
//        Iterator<String> answerIterator = student.getAnswers().iterator();
//        Iterator<String> questionIterator = questions.iterator();
//
//        int right = 0;
//        int wrong = 0;
//
//        while( questionIterator.hasNext() && answerIterator.hasNext()) {
//
//          String question = questionIterator.next();
//          String answer = answerIterator.next();
//          String key = keys.get(question);
//
//          // if the answer is NA then the student did not get asked the question
//          // skip questions with NA answers
//
//          if( answer.equalsIgnoreCase("NA")) {
//            // skip this question
//            continue;
//          }
//
//          if( !answer.equalsIgnoreCase(key) ) {
//            recommendation.addMissedQuestion(question);
//            recommendation.addCourse(mappings.getCourse(question));
//          }
//
//        }
//
//        recommendations.add(recommendation);
//
//      }
//
//    }
//
//    return null;
//  }

}
