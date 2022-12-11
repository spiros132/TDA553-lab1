package objects.car;
import java.awt.*;

import objects.car.modifiers.Trim;

public class Volvo240 extends Car{
    
    private Trim trim;

    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        trim = new Trim(1.25d);
        modelName = "Volvo240";
        stopEngine();
    }

    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trim.getTrimFactor();
    }
}
