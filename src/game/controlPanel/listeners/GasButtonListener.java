package game.controlPanel.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.controlPanel.ControlPanel;

public class GasButtonListener implements ActionListener {

    private ControlPanel model;

    public GasButtonListener(ControlPanel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.gas();
    }
    
}
