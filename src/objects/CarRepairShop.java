package objects;

import objects.car.modifiers.CarLoader;
import utilities.Vector2D;
import objects.car.Car;

public class CarRepairShop extends GameObject {

    private CarLoader carLoader;
    private Vector2D unloadOffset;

    public CarRepairShop(int maxSize, Vector2D unloadOffset) {
        this.unloadOffset = unloadOffset;
        carLoader = new CarLoader(maxSize, 5);
        
    }

    public void Load(Car car) {
        carLoader.Load(car, GetCurrentPosition());
    }

    public Car Unload(int index) {
        Car unloadedCar =  carLoader.Unload(index);

        unloadedCar.MoveToPosition(Vector2D.Add(GetCurrentPosition(), unloadOffset));

        return unloadedCar;
    }
}