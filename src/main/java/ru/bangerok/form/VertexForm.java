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

    private final JPanel vertexPanel;
    private final JLabel randomNumberValue;
    private JPopupMenu contextMenu;

    public VertexForm() {
        super(TITLE);

        Dimension size = new Dimension(110, 110);
        this.setPreferredSize(size);
        this.setUndecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Container container = this.getContentPane();

        vertexPanel = new JPanel();
        randomNumberValue = new JLabel();
        randomNumberValue.setPreferredSize(size);
        randomNumberValue.setHorizontalAlignment(SwingConstants.CENTER);
        randomNumberValue.setVerticalAlignment(SwingConstants.CENTER);
        randomNumberValue.setFont(new Font("Courier New", Font.PLAIN, 72));

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
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        getService().generateAndUpdateForm(vertexPanel, randomNumberValue);

        vertexPanel.add(randomNumberValue);
        vertexPanel.add(contextMenu);
        container.add(vertexPanel);
    }

    private void creatingContextMenu(Timer oneSecondTimer, Timer oneAndHalfSecondTimer) {
        JMenuItem oneSecondMenuItem = getService().creatingWithTimerItemMenu("1 секунда", oneSecondTimer);
        JMenuItem oneAndHalfSecondMenuItem = getService().creatingWithTimerItemMenu("1.5 секунды", oneAndHalfSecondTimer);

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
