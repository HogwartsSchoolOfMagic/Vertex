package io.github.hogwartsschoolofmagic.vertex.form;

import static io.github.hogwartsschoolofmagic.vertex.util.VertexUtil.creatingWithTimerItemMenu;
import static io.github.hogwartsschoolofmagic.vertex.util.VertexUtil.generateAndUpdateForm;
import static java.awt.event.MouseEvent.BUTTON1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import lombok.Getter;

/**
 * A shape that displays a random number and its corresponding color.
 *
 * @author Vladislav [SmithyVL] Vladislav.
 * @since 0.0.1.
 */
@Getter
public class VertexForm extends JFrame {

  private final Dimension dimension = new Dimension(110, 110);

  /**
   * Form initialization with all timers, menus and listeners.
   */
  public VertexForm() {
    super("VertexForm");
    configuringFrame();

    var vertexPanel = new JPanel();
    var rndField = configuringRandomNumberLabel();
    var firstTimer = new Timer(1000, e -> generateAndUpdateForm(vertexPanel, rndField));
    var secondTimer = new Timer(1500, e -> generateAndUpdateForm(vertexPanel, rndField));
    var menu = creatingContextMenu(firstTimer, secondTimer);

    vertexPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getButton() == BUTTON1 && (!firstTimer.isRunning() && !secondTimer.isRunning())) {
          generateAndUpdateForm(vertexPanel, rndField);
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
          menu.getComponent(3).setEnabled(firstTimer.isRunning() || secondTimer.isRunning());
          menu.getComponent(0).setEnabled(!firstTimer.isRunning() && !secondTimer.isRunning());
          menu.getComponent(1).setEnabled(!firstTimer.isRunning() && !secondTimer.isRunning());
          menu.show(e.getComponent(), e.getX(), e.getY());
        }
      }
    });

    generateAndUpdateForm(vertexPanel, rndField);
    vertexPanel.add(rndField);
    vertexPanel.add(menu);
    this.getContentPane().add(vertexPanel);
  }

  /**
   * Basic form settings.
   */
  private void configuringFrame() {
    setPreferredSize(dimension);
    setUndecorated(true);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setAlwaysOnTop(true);
  }

  /**
   * Field configuration for a random number.
   *
   * @return configured field.
   */
  private JLabel configuringRandomNumberLabel() {
    var label = new JLabel();
    label.setPreferredSize(dimension);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setVerticalAlignment(SwingConstants.CENTER);
    label.setFont(new Font("Courier New", Font.PLAIN, 72));

    return label;
  }

  /**
   * Creation and configuration of a contextual, pop-up menu.
   *
   * @param firstTimer  first timer for the menu.
   * @param secondTimer second timer for the menu.
   * @return configured context/popup menu.
   */
  private JPopupMenu creatingContextMenu(Timer firstTimer, Timer secondTimer) {
    var contextMenu = new JPopupMenu();

    var oneSecondMenuItem = creatingWithTimerItemMenu("1 секунда", firstTimer);
    contextMenu.add(oneSecondMenuItem);

    var oneAndHalfSecondMenuItem = creatingWithTimerItemMenu("1.5 секунды", secondTimer);
    contextMenu.add(oneAndHalfSecondMenuItem);
    contextMenu.add(new JSeparator());

    var stoppedMenuItem = new JMenuItem(new AbstractAction("Выключить авто обновление") {
      public void actionPerformed(ActionEvent e) {
        int indexMenuItem = 0;
        if (firstTimer.isRunning()) {
          firstTimer.stop();
        }

        if (secondTimer.isRunning()) {
          indexMenuItem = 1;
          secondTimer.stop();
        }

        var menuItem = (JMenuItem) contextMenu.getComponent(indexMenuItem);
        menuItem.setText(menuItem.getText().substring(0, indexMenuItem == 0 ? 9 : 11));
      }
    });
    contextMenu.add(stoppedMenuItem);
    contextMenu.add(new JSeparator());

    var exitMenuItem = new JMenuItem(new AbstractAction("Выйти") {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    contextMenu.add(exitMenuItem);

    return contextMenu;
  }
}