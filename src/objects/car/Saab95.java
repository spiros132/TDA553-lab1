package objects.car;
import java.awt.*;

import game.GameImages;
import objects.car.modifiers.IHasTurbo;
import objects.car.modifiers.Turbo;

public class Saab95 extends Car implements IHasTurbo {

    private Turbo turbo;
    
    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turbo = new Turbo(0.33d);
        modelName = "Saab95";

        setGameObjectImage(GameImages.GetSaab95Image());

        stopEngine();
    }

    public void setTurboOn(){
	    turbo.turnOn();
    }

    public void setTurboOff(){
	    turbo.turnOff();
    }
    
    @Override
    protected double speedFactor(){
        double turboAmount = 1 + turbo.getTurboAmount();
        return enginePower * 0.01 * turboAmount;
    }
 
}
