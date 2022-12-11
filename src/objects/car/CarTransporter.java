package objects.car;

import java.awt.*;

import objects.car.modifiers.CarLoader;
import objects.car.modifiers.Ramp;
import utilities.Vector2D;

public class CarTransporter extends Car {
    private Ramp ramp;
    private CarLoader carLoader;
    private Vector2D unloadOffset;
    
    public CarTransporter() {
        nrDoors = 2;
        color = Color.white;
        enginePower = 60;
        ramp = new Ramp(1, 0, 1);
        carLoader = new CarLoader(5,5);
        modelName = "CarTransporter";
        unloadOffset = new Vector2D(0, -2);
        stopEngine();
    }

    public void raise() {
        ramp.raise(1);
    }
    public void lower() {
        ramp.lower(1);
    }

    void raiseRamp(int angle) {
        if(getCurrentSpeed() <= 0 && angle > 0) {
            ramp.raise(angle);
        }
    }
    void lowerRamp(int angle) {
        if(getCurrentSpeed() <= 0 && angle > 0) {
            ramp.lower(angle);
        }
    }


    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void move() {
        super.move();

        carLoader.moveCars(getCurrentPosition());
    }

    @Override
    protected boolean canDrive() {
        return ramp.getAngle() == ramp.getMaxAngle();
    }
 

    public void load(Car car) {
        if(ramp.getAngle() == 0) {
            carLoader.load(car, getCurrentPosition());
            car.moveToPosition(getCurrentPosition());
        }
    }

    public Car unload(int index) {
        if(ramp.getAngle() == 0) {
            Car unloadedCar =  carLoader.unload(index);

            unloadedCar.moveToPosition(Vector2D.add(getCurrentPosition(), unloadOffset));

            return unloadedCar;
        }
        
        return null;
    }

    public Car[] getCars() {
        return carLoader.getCars();
    }
}
