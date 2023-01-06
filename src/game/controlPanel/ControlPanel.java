package game.controlPanel;

import game.Game;

public class ControlPanel {
    Game model;

    public ControlPanel(Game model) {
        this.model = model;
    }

    public void gas() {
        model.gas();
    }

    public void brake() {
        model.brake();
    }

    public void turboOn() {
        model.turboOn();
    }

    public void turboOff() {
        model.turboOff();
    }

    public void lowerBed() {
        model.lowerBed();
    }

    public void liftBed() {
        model.liftBed();
    }

    public double getGasAmount() {
        return model.getGasAmount();
    }
    public void setGasAmount(int gasAmount) {
       model.setGasAmount(gasAmount);
    }

    public void startAllEngines() {
        model.startAllEngines();
    }

    public void stopAllEngines() {
        model.stopAllEngines();
    }
}
