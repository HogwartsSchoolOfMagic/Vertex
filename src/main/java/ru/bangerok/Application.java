package ru.bangerok;

import ru.bangerok.form.VertexForm;
import ru.bangerok.service.VertexServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Application {

    public static final String TITLE = "VertexForm";

    public static void main(String[] args) {
        Runnable runnable = Application::run;
        SwingUtilities.invokeLater(runnable);
    }

    private static void run() {
        JFrame frame = new JFrame(TITLE);
        frame.setUndecorated(true);
        frame.setContentPane(new VertexForm(new VertexServiceImpl()).getVertexPanel());
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
}
