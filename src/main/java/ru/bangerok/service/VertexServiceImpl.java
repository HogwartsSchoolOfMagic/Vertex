package ru.bangerok.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class VertexServiceImpl implements VertexService {
    private final Random random = new Random();

    @Override
    public void generateAndUpdateForm(JPanel vertexPanel, JLabel randomNumberValue) {
        int randomNumber = random.nextInt(100);
        Color color;
        if (randomNumber <= 49) {
            color = new Color(53, 203, 7);
        } else {
            color = new Color(255, 255, 51);
        }

        vertexPanel.setBackground(color);
        randomNumberValue.setText(String.valueOf(randomNumber));
    }

    @Override
    public JMenuItem creatingWithTimerItemMenu(String title, Timer timer) {
        return new JMenuItem(new AbstractAction(title) {
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                menuItem.setText(menuItem.getText().concat(" [ON]"));
                timer.start();
            }
        });
    }
}
