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
        StopEngine();
    }

    public void Raise() {
        ramp.Raise(1);
    }

    public void Lower() {
        ramp.Lower(1);
    }


    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    @Override
    public void Move() {
        super.Move();

        carLoader.MoveCars(GetCurrentPosition());
    }

    @Override
    protected boolean canDrive() {
        return ramp.GetAngle() == ramp.GetMaxAngle();
    }
 

    public void Load(Car car) {
        if(ramp.GetAngle() == 0) {
            carLoader.Load(car, GetCurrentPosition());
            car.MoveToPosition(GetCurrentPosition());
        }
    }

    public Car Unload(int index) {
        if(ramp.GetAngle() == 0) {
            Car unloadedCar =  carLoader.Unload(index);

            unloadedCar.MoveToPosition(Vector2D.Add(GetCurrentPosition(), unloadOffset));

            return unloadedCar;
        }
        
        return null;
    }

    public Car[] GetCars() {
        return carLoader.GetCars();
    }
}
