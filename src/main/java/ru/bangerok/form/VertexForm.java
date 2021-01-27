package ru.bangerok.form;

import lombok.Getter;
import ru.bangerok.service.VertexService;

import javax.swing.*;
import java.awt.event.*;

@Getter
public class VertexForm {

    private final VertexService service;

    private JPanel vertexPanel;
    private JLabel randomNumberValue;
    private JPopupMenu contextMenu;

    public VertexForm(VertexService service) {
        this.service = service;

        Timer oneSecondTimer = new Timer(1000, e -> service.generateAndUpdateForm(vertexPanel, randomNumberValue));
        Timer oneAndHalfSecondTimer = new Timer(1500, e -> service.generateAndUpdateForm(vertexPanel, randomNumberValue));
        creatingContextMenu(oneSecondTimer, oneAndHalfSecondTimer);

        vertexPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 &&
                    (!oneSecondTimer.isRunning() && !oneAndHalfSecondTimer.isRunning())) {
                    service.generateAndUpdateForm(vertexPanel, randomNumberValue);
                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    contextMenu.getComponent(2).setEnabled(oneSecondTimer.isRunning() || oneAndHalfSecondTimer.isRunning());
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void creatingContextMenu(Timer oneSecondTimer, Timer oneAndHalfSecondTimer) {
        JMenuItem oneSecondMenuItem = service.creatingWithTimerItemMenu("1 секунда", oneSecondTimer);
        JMenuItem oneAndHalfSecondMenuItem = service.creatingWithTimerItemMenu("1.5 секунды", oneAndHalfSecondTimer);

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
    }
}
