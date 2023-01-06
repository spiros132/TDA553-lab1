package game.controlPanel.listeners;

import game.controlPanel.ControlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BrakeButtonListener implements ActionListener {
    private ControlPanel model;

    public BrakeButtonListener(ControlPanel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.brake();
    }
}
