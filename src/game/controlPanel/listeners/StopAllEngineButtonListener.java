package game.controlPanel.listeners;

import game.controlPanel.ControlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopAllEngineButtonListener implements ActionListener {
    private ControlPanel model;

    public StopAllEngineButtonListener(ControlPanel model){
        this.model = model;
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        model.stopAllEngines();
    }

}
