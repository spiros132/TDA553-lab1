package game.controlPanel.listeners;

import game.controlPanel.ControlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurboOnButtonListener implements ActionListener {
    private ControlPanel model;

    public TurboOnButtonListener(ControlPanel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        model.turboOn();
    }
}
