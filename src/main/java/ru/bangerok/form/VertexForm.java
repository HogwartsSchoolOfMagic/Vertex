package ru.bangerok.form;

import lombok.Getter;
import ru.bangerok.service.VertexService;
import ru.bangerok.service.VertexServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@Getter
public class VertexForm extends JFrame {
    public static final String TITLE = "VertexForm";

    private final Dimension classicSize = new Dimension(110, 110);
    private final JPanel vertexPanel = new JPanel();
    private final JLabel randomNumberValue = configuringRandomNumberLabel();
    private JPopupMenu contextMenu;

    public VertexForm() {
        super(TITLE);
        configuringFrame();

        Timer oneSecondTimer = new Timer(1000, e -> getService().generateAndUpdateForm(vertexPanel, randomNumberValue));
        Timer oneAndHalfSecondTimer = new Timer(1500, e -> getService().generateAndUpdateForm(vertexPanel, randomNumberValue));
        creatingContextMenu(oneSecondTimer, oneAndHalfSecondTimer);

        vertexPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 &&
                        (!oneSecondTimer.isRunning() && !oneAndHalfSecondTimer.isRunning())) {
                    getService().generateAndUpdateForm(vertexPanel, randomNumberValue);
                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    contextMenu.getComponent(3).setEnabled(oneSecondTimer.isRunning() || oneAndHalfSecondTimer.isRunning());
                    contextMenu.getComponent(0).setEnabled(!oneSecondTimer.isRunning() && !oneAndHalfSecondTimer.isRunning());
                    contextMenu.getComponent(1).setEnabled(!oneSecondTimer.isRunning() && !oneAndHalfSecondTimer.isRunning());
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        getService().generateAndUpdateForm(vertexPanel, randomNumberValue);
        vertexPanel.add(randomNumberValue);
        vertexPanel.add(contextMenu);
        this.getContentPane().add(vertexPanel);
    }

    private void configuringFrame() {
        this.setPreferredSize(classicSize);
        this.setUndecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JLabel configuringRandomNumberLabel() {
        JLabel label = new JLabel();
        label.setPreferredSize(classicSize);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Courier New", Font.PLAIN, 72));

        return label;
    }

    private void creatingContextMenu(Timer oneSecondTimer, Timer oneAndHalfSecondTimer) {
        JMenuItem oneSecondMenuItem = getService().creatingWithTimerItemMenu("1 секунда", oneSecondTimer);
        JMenuItem oneAndHalfSecondMenuItem = getService().creatingWithTimerItemMenu("1.5 секунды", oneAndHalfSecondTimer);

        JMenuItem stoppedMenuItem = new JMenuItem(new AbstractAction("Выключить авто обновление") {
            public void actionPerformed(ActionEvent e) {
                int indexMenuItem = 0;
                if (oneSecondTimer.isRunning()) {
                    oneSecondTimer.stop();
                }

                if (oneAndHalfSecondTimer.isRunning()) {
                    indexMenuItem = 1;
                    oneAndHalfSecondTimer.stop();
                }

                JMenuItem menuItem = (JMenuItem) contextMenu.getComponent(indexMenuItem);
                menuItem.setText(menuItem.getText().substring(0, indexMenuItem == 0 ? 9 : 11));
            }
        });

        JMenuItem exitMenuItem = new JMenuItem(new AbstractAction("Выйти") {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        contextMenu = new JPopupMenu();
        contextMenu.add(oneSecondMenuItem);
        contextMenu.add(oneAndHalfSecondMenuItem);
        contextMenu.add(new JSeparator());
        contextMenu.add(stoppedMenuItem);
        contextMenu.add(new JSeparator());
        contextMenu.add(exitMenuItem);
    }

    private VertexService getService() {
        return new VertexServiceImpl();
    }
}
