package game.controlPanel.listeners;

import game.controlPanel.ControlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LowerBedButtonListener implements ActionListener{
    private ControlPanel model;

    public LowerBedButtonListener(ControlPanel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.lowerBed();
    }
}
