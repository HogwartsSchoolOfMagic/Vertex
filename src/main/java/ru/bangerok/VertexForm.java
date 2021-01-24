package ru.bangerok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class VertexForm {
    private JPanel vertexPanel;
    private JLabel randomNumberValue;
    private JPopupMenu contextMenu;

    public VertexForm() {
        Timer oneSecondTimer = new Timer(1000, e -> generateAndUpdateForm());
        Timer oneAndHalfSecondTimer = new Timer(1500, e -> generateAndUpdateForm());

        JMenuItem oneSecondMenuItem = creatingWithTimerItemMenu("1 секунда", oneSecondTimer);
        JMenuItem oneAndHalfSecondMenuItem = creatingWithTimerItemMenu("1.5 секунды", oneAndHalfSecondTimer);

        JMenuItem stoppedMenuItem = new JMenuItem(new AbstractAction("Выключить авто обновление") {
            public void actionPerformed(ActionEvent e) {
                if (oneSecondTimer.isRunning()) {
                    oneSecondTimer.stop();
                }

                if (oneAndHalfSecondTimer.isRunning()) {
                    oneAndHalfSecondTimer.stop();
                }
            }
        });

        contextMenu.add(oneSecondMenuItem);
        contextMenu.add(oneAndHalfSecondMenuItem);
        contextMenu.add(stoppedMenuItem);

        vertexPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (!oneSecondTimer.isRunning() && !oneAndHalfSecondTimer.isRunning()) {
                        generateAndUpdateForm();
                    }
                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    contextMenu.getComponent(2).setEnabled(oneSecondTimer.isRunning() || oneAndHalfSecondTimer.isRunning());
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void generateAndUpdateForm() {
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

    private JMenuItem creatingWithTimerItemMenu(String title, Timer timer) {
        return new JMenuItem(new AbstractAction(title) {
            public void actionPerformed(ActionEvent e) {
                timer.start();
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
