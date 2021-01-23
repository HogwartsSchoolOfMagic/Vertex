package ru.bangerok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class VertexForm {
    private JPanel vertexPanel;
    private JLabel randomNumberValue;
    private JPopupMenu contextMenu;

    public VertexForm() {
        contextMenu.add(new JMenuItem("Cut"));

        vertexPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Random random = new Random();

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

                if (e.getButton() == MouseEvent.BUTTON3) {
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VertexForm");
        frame.setUndecorated(true);
        frame.setContentPane(new VertexForm().vertexPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
