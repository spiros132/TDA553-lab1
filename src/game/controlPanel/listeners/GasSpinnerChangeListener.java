package game.controlPanel.listeners;

import game.controlPanel.ControlPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GasSpinnerChangeListener implements ChangeListener {
    private ControlPanel model;
    
    public GasSpinnerChangeListener(ControlPanel model) {
        this.model = model;
    }

    public void stateChanged(ChangeEvent e) {
        var gasAmount = (int) ((JSpinner)e.getSource()).getValue();

        model.setGasAmount(gasAmount);
    }
}

