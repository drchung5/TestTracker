package com.webage.testtracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {

  public UserInterface() {

    JFrame frame = new JFrame("Test Tracker");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,200);
    setUpGUI(frame.getContentPane());
    frame.setVisible(true);
  }

  private void setUpGUI(Container pane) {

    JFileChooser fileChooser = new JFileChooser();

    JButton resultsButton   = new JButton("Select Results File");

    resultsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(pane);
      }
    });


    JButton answerkeyButton = new JButton("Select Answer Key File");
    JButton mappingButton    = new JButton("Select Mapping File");
    JButton runButton       = new JButton("Run Analysis");

    JLabel resultsLabel   = new JLabel();

    pane.setLayout(new GridLayout(4,1));
    pane.add(resultsButton);
    pane.add(answerkeyButton);
    pane.add(mappingButton);
    pane.add(runButton);

    answerkeyButton.setEnabled(false);
    mappingButton.setEnabled(false);
    runButton.setEnabled(false);

  }


}
