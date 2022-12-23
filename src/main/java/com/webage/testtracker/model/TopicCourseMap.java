package com.webage.testtracker.model;

import java.util.ArrayList;

public class TopicCourseMap {


  public ArrayList<Course> courses = new ArrayList<>();

  public Course getCourse(int topicNumber) {
    Course returnValue = null;


    for(Course course : courses ) {
      if( course.getTopicNumbers().contains(topicNumber) ) {
        returnValue = course;
        break;
      }
    }

    return returnValue;
  }

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();

    for( Course course : courses) {
      stringBuilder.append(course);
    }

    return stringBuilder.toString();
  }
}

