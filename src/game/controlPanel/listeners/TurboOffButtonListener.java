package game.controlPanel.listeners;

import game.controlPanel.ControlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurboOffButtonListener implements ActionListener {
    private ControlPanel model;

    public TurboOffButtonListener(ControlPanel model){
        this.model = model;
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        model.turboOff();
    }
}
