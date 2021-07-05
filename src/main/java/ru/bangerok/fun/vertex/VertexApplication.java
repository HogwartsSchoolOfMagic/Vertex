package ru.bangerok.fun.vertex;

import static javax.swing.SwingUtilities.invokeLater;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import ru.bangerok.fun.vertex.form.VertexForm;

public class VertexApplication {

  public static void main(String[] args) {
    Runnable runnable = VertexApplication::run;
    invokeLater(runnable);
  }

  private static void run() {
    VertexForm frame = new VertexForm();

    final Point[] mouseDownCompCoords = {null};
    frame.getContentPane().getComponent(0).addMouseListener(new MouseListener() {
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

    frame.getContentPane().getComponent(0).addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        frame.setLocation(currCoords.x - mouseDownCompCoords[0].x,
            currCoords.y - mouseDownCompCoords[0].y);
      }

      @Override
      public void mouseMoved(MouseEvent e) {
        // Needed for working
      }
    });
  }
}