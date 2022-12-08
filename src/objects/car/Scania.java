package objects.car;
import java.awt.*;

import objects.car.modifiers.Ramp;

 public class Scania extends Car {
    public final int rampMaxAngle = 70;
    public final int rampMinAngle = 0;

    private Ramp ramp;


    public Scania() {
        nrDoors = 2;
        color = Color.orange;
        enginePower = 90;
        ramp = new Ramp(rampMinAngle,rampMinAngle,rampMaxAngle);
        modelName ="Scania";
        StopEngine();
    }

    @Override
    protected double speedFactor() {

        return enginePower * 0.01;
    }

    public void Raise(int angle) {
        if(GetCurrentSpeed() <= 0){
            ramp.Raise(angle);
        }
    }

    public void Lower(int angle) {
        if(GetCurrentSpeed() <= 0)
            ramp.Lower(angle);
    }

    @Override
    protected boolean canDrive() {
        return ramp.GetAngle() == ramp.GetMinAngle();
    }
 
 }