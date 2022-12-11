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

    public void load(Car car) {
        carLoader.load(car, getCurrentPosition());
    }

    public Car unload(int index) {
        Car unloadedCar =  carLoader.unload(index);

        unloadedCar.moveToPosition(Vector2D.add(getCurrentPosition(), unloadOffset));

        return unloadedCar;
    }
}