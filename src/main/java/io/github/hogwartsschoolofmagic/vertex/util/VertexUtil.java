package io.github.hogwartsschoolofmagic.vertex.util;

import io.github.hogwartsschoolofmagic.vertex.form.VertexForm;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.security.SecureRandom;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Vertex Form Utilities.
 *
 * @author Vladislav [SmithyVL] Kuznetsov.
 * @since 0.2.1.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VertexUtil {

  private static final SecureRandom rnd = new SecureRandom();

  /**
   * Generation of a random number from 0 to 100 and, according to the resulting number,
   * the choice of color to display it on the form along with the number.
   *
   * @param vertexPanel       application form.
   * @param randomNumberValue field displaying number.
   */
  public static void generateAndUpdateForm(JPanel vertexPanel, JLabel randomNumberValue) {
    var randomNumber = rnd.nextInt(100);
    Color color;
    if (randomNumber <= 49) {
      color = new Color(53, 203, 7);
    } else {
      color = new Color(255, 255, 51);
    }

    vertexPanel.setBackground(color);
    randomNumberValue.setText(String.valueOf(randomNumber));
  }

  /**
   * Form element creation - popup submenu.
   *
   * @param title submenu title.
   * @param timer timer that starts by clicking on a submenu.
   * @return popup menu item.
   */
  public static JMenuItem creatingWithTimerItemMenu(String title, Timer timer) {
    return new JMenuItem(new AbstractAction(title) {
      public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        menuItem.setText(menuItem.getText().concat(" [ON]"));
        timer.start();
      }
    });
  }

  /**
   * Start displaying a form with listeners for its events.
   */
  public static void started() {
    var frame = new VertexForm();

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
        var currCoords = e.getLocationOnScreen();
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