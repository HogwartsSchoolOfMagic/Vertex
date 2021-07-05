package ru.bangerok.fun.vertex.service;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

public interface VertexService {
  void generateAndUpdateForm(JPanel vertexPanel, JLabel randomNumberValue);

  JMenuItem creatingWithTimerItemMenu(String title, Timer timer);
}