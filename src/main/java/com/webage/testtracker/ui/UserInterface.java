package com.webage.testtracker.ui;

import com.webage.testtracker.controller.TestController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class UserInterface {

  private String resultsFilePath   = null;
  private String answerTopicKeyFilePath = null;
  private String topicArticleMapFilePath   = null;
  private String topicCourseMapFilePath   = null;

  JFrame frame;

  private JFileChooser fileChooser = new JFileChooser();

  private JButton resultsButton         = new JButton("Select Results File");
  private JButton answerTopicKeyButton  = new JButton("Select Answer Topic Key File");
  private JButton topicArticleMapButton = new JButton("Select Topic Article Map File");
  private JButton topicCourseMapButton  = new JButton("Select Topic Course Map File");
  private JButton runButton             = new JButton("Run Analysis");

  public UserInterface() {
    frame = new JFrame("Test Tracker");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,210);
    setUpGUI(frame.getContentPane());
    addListeners(frame.getContentPane());
    frame.setVisible(true);
  }

  private void setUpGUI(Container pane) {

    pane.setLayout(new GridLayout(5,1));
    pane.add(resultsButton);
    pane.add(answerTopicKeyButton);
    pane.add(topicArticleMapButton);
    pane.add(topicCourseMapButton);
    pane.add(runButton);

    answerTopicKeyButton.setEnabled(false);
    topicArticleMapButton.setEnabled(false);
    topicCourseMapButton.setEnabled(false);
    runButton.setEnabled(false);



  }

  private void addListeners(Container pane) {

    resultsButton.addActionListener(e -> {

      fileChooser.setFileFilter(new FileNameExtensionFilter("Results files (.csv)","csv"));
      fileChooser.setDialogTitle("Open Results File");

      int returnVal = fileChooser.showDialog(pane, "Open Results File");

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        resultsFilePath = selectedFile.getAbsolutePath();

        System.out.println("Results file: " + resultsFilePath);

        resultsButton.setEnabled(false);
        answerTopicKeyButton.setEnabled(true);
      }

    });

    answerTopicKeyButton.addActionListener(e -> {

      fileChooser.setFileFilter(new FileNameExtensionFilter("Results files (.csv)","csv"));
      fileChooser.setDialogTitle("Open Answer Topic Key File");

      int returnVal = fileChooser.showDialog(pane, "Open Answer Topic Key File");

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        answerTopicKeyFilePath = selectedFile.getAbsolutePath();

        System.out.println("Answer Topic Key file: " + answerTopicKeyFilePath);

        answerTopicKeyButton.setEnabled(false);
        topicArticleMapButton.setEnabled(true);
      }

    });

    topicArticleMapButton.addActionListener(e -> {

      fileChooser.setFileFilter(new FileNameExtensionFilter("Map files (.json)","json"));
      fileChooser.setDialogTitle("Open Topic Article Map File");

      int returnVal = fileChooser.showDialog(pane, "Open Topic Article Map File");

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        topicArticleMapFilePath = selectedFile.getAbsolutePath();

        System.out.println("Topic Article Mapping file: " + topicArticleMapFilePath);

        topicArticleMapButton.setEnabled(false);
        topicCourseMapButton.setEnabled(true);
      }

    });

    topicCourseMapButton.addActionListener(e -> {

      fileChooser.setFileFilter(new FileNameExtensionFilter("Map files (.json)","json"));
      fileChooser.setDialogTitle("Open Topic Course Map File");
      int returnVal = fileChooser.showDialog(pane, "Open Topic Course Map File");

      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        topicCourseMapFilePath = selectedFile.getAbsolutePath();

        System.out.println("Topic Course Map file: " + topicCourseMapFilePath);

        topicCourseMapButton.setEnabled(false);
        runButton.setEnabled(true);
      }

    });

    runButton.addActionListener(e -> {

      TestController.processResults(
                              resultsFilePath,
                              answerTopicKeyFilePath,
                              topicArticleMapFilePath,
                              topicCourseMapFilePath);

      ResultsDialog resultsDialog = new ResultsDialog(frame, "Result", "recomendations.txt written");
      resultsDialog.setVisible(true);

      System.exit(1);
    });

  }


}
