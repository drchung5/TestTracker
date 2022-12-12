package com.webage.testtracker.ui;

import com.webage.testtracker.controller.TestController;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;

public class UserInterface {

  private String resultsFilePath   = null;
  private String answerKeyFilePath = null;
  private String mappingFilePath   = null;

  JFrame frame = null;

  private JFileChooser fileChooser = new JFileChooser();

  private JButton resultsButton   = new JButton("Select Results File");
  private JButton answerkeyButton = new JButton("Select Answer Key File");
  private JButton mappingButton   = new JButton("Select Mapping File");
  private JButton runButton       = new JButton("Run Analysis");

  public UserInterface() {
    frame = new JFrame("Test Tracker");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,200);
    setUpGUI(frame.getContentPane());
    addListeners(frame.getContentPane());
    frame.setVisible(true);
  }

  private void setUpGUI(Container pane) {

    fileChooser.setFileFilter(new FileNameExtensionFilter("Test files (.csv)","csv"));

    pane.setLayout(new GridLayout(5,1));
    pane.add(resultsButton);
    pane.add(answerkeyButton);
    pane.add(mappingButton);
    pane.add(runButton);

    answerkeyButton.setEnabled(false);
    mappingButton.setEnabled(false);
    runButton.setEnabled(false);



  }

  private void addListeners(Container pane) {

    resultsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showDialog(pane, "Open Results File");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          resultsFilePath = selectedFile.getAbsolutePath();

          System.out.println("Results file: " + resultsFilePath);

          resultsButton.setEnabled(false);
          answerkeyButton.setEnabled(true);
        }

      }
    });

    answerkeyButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showDialog(pane, "Open Answer Key File");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          answerKeyFilePath = selectedFile.getAbsolutePath();

          System.out.println("Answer Key file: " + answerKeyFilePath);

          answerkeyButton.setEnabled(false);
          mappingButton.setEnabled(true);
        }

      }
    });

    mappingButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showDialog(pane, "Open Mapping File");

        if (returnVal == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          mappingFilePath = selectedFile.getAbsolutePath();

          System.out.println("Mapping file: " + mappingFilePath);

          mappingButton.setEnabled(false);
          runButton.setEnabled(true);
        }

      }
    });

    runButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        TestController.processResults( resultsFilePath, answerKeyFilePath, mappingFilePath);

        ResultsDialog resultsDialog = new ResultsDialog(frame, "Result", "recomendations.txt written");
        resultsDialog.setVisible(true);

        System.exit(1);
      }
    });

  }

}
