package ru.bangerok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class VertexForm {
    private final Random random = new Random();
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
                if (e.getButton() == MouseEvent.BUTTON1 &&
                        (!oneSecondTimer.isRunning() && !oneAndHalfSecondTimer.isRunning())) {
                    generateAndUpdateForm();
                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    contextMenu.getComponent(2).setEnabled(oneSecondTimer.isRunning() || oneAndHalfSecondTimer.isRunning());
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    public static void main(String[] args) {
        Runnable runnable = VertexForm::run;
        SwingUtilities.invokeLater(runnable);
    }

    private static void run() {
        JFrame frame = new JFrame("VertexForm");
        frame.setUndecorated(true);
        frame.setContentPane(new VertexForm().vertexPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        final Point[] mouseDownCompCoords = {null};
        frame.getContentPane().addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords[0] = null;
            }

            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords[0] = e.getPoint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Needed for working
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Needed for working
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Needed for working
            }
        });

        frame.getContentPane().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                frame.setLocation(currCoords.x - mouseDownCompCoords[0].x, currCoords.y - mouseDownCompCoords[0].y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Needed for working
            }
        });
    }

    private void generateAndUpdateForm() {
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
}
