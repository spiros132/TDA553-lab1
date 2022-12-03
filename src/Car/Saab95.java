package car;
import java.awt.*;

public class Saab95 extends Car {

    private Turbo turbo;
    
    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turbo = new Turbo(0.33d);
        modelName = "Saab95";
        StopEngine();
    }

    public void setTurboOn(){
	    turbo.TurnOn();
    }

    public void setTurboOff(){
	    turbo.TurnOff();
    }
    
    @Override
    protected double speedFactor(){
        double turboAmount = 1 + turbo.GetTurboAmount();
        return enginePower * 0.01 * turboAmount;
    }
 
}
