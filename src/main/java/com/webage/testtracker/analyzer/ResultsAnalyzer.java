package com.webage.testtracker.analyzer;

import com.webage.testtracker.model.*;

import java.util.*;

public class ResultsAnalyzer {

  public static List<Recommendation> getRecommendations(
                                    Results results,
                                    Mappings mappings,
                                    AnswerKey answerKey,
                                    int threshold) {

    // ordered list of questions (full text)
    List<String> questions = results.getQuestions();

    // map of question => answer
    Map<String,String> keys = answerKey.getKeys();

    ArrayList<Recommendation> recommendations = new ArrayList<>();


    // iterate through students
    for(Student student: results.getStudents()) {

      // check scores
      if( student.getScore() <= threshold ) {

        Recommendation recommendation = new Recommendation(
                                                    student.getName(),
                                                    student.getEmail(),
                                                    student.getScore()
                                                );

        ArrayList<String> missedQuestions = new ArrayList<>();
        Set<Course> courses = new HashSet<>();


        // get an iterator for the answers and for the questions
        // will iterate through them together
        Iterator<String> answerIterator = student.getAnswers().iterator();
        Iterator<String> questionIterator = questions.iterator();

        int right = 0;
        int wrong = 0;

        while( questionIterator.hasNext() && answerIterator.hasNext()) {

          String question = questionIterator.next();
          String answer = answerIterator.next();
          String key = keys.get(question);

          if( !answer.equalsIgnoreCase(key) ) {
            recommendation.addMissedQuestion(question);
            recommendation.addCourse(mappings.getCourse(question));
          }

        }

        recommendations.add(recommendation);

      }

    }

    return recommendations;
  }

}
