package game.controlPanel.listeners;

import game.controlPanel.ControlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartAllEngineButtonListener implements ActionListener {
    private ControlPanel model;

    public StartAllEngineButtonListener(ControlPanel model){
        this.model = model;
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        model.startAllEngines();
    }

}
