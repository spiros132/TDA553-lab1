package game.controlPanel.listeners;

import game.controlPanel.ControlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LiftBedButtonListener implements ActionListener {
    private ControlPanel model;

    public LiftBedButtonListener(ControlPanel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.liftBed();
    }
}
