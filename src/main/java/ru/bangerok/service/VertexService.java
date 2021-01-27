package ru.bangerok.service;

import javax.swing.*;

public interface VertexService {
    void generateAndUpdateForm(JPanel vertexPanel, JLabel randomNumberValue);
    JMenuItem creatingWithTimerItemMenu(String title, Timer timer);
}
