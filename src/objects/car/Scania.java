package objects.car;

import java.awt.*;
import game.GameImages;
import objects.car.modifiers.IHasRamp;
import objects.car.modifiers.Ramp;

 public class Scania extends Car implements IHasRamp {
    public final int rampMaxAngle = 70;
    public final int rampMinAngle = 0;

    private Ramp ramp;


    public Scania() {
        nrDoors = 2;
        color = Color.orange;
        enginePower = 90;
        ramp = new Ramp(rampMinAngle,rampMinAngle,rampMaxAngle);
        modelName ="Scania";
        setGameObjectImage(GameImages.GetScaniaImage());
        stopEngine();
    }

    @Override
    protected double speedFactor() {

        return enginePower * 0.01;
    }

    public void raise(int angle) {
        if(getCurrentSpeed() <= 0 && angle > 0) {
            ramp.raise(angle);
        }
    }
    
    public void lower(int angle) {
        if(getCurrentSpeed() <= 0 && angle > 0) {
            ramp.lower(angle);
        }
    }

    @Override
    protected boolean canDrive() {
        return ramp.getAngle() == ramp.getMinAngle();
    }
 
 }