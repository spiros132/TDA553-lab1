package car;
import java.awt.*;

public class Volvo240 extends Car{
    
    private Trim trim;

    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        trim = new Trim(1.25d);
        stopEngine();
    }

    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trim.getTrimFactor();
    }
}
