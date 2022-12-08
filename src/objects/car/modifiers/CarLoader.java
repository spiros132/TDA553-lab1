package objects.car.modifiers;

import java.util.ArrayList;

import objects.car.Car;
import utilities.Vector2D;

public class CarLoader {
    ArrayList<Car> cars;
    int maxSize;
    int maxLoadingDistance;

    public CarLoader(int maxSize, int maxLoadingDistance) {
        this.maxSize = maxSize;
        this.maxLoadingDistance = maxLoadingDistance;
        cars = new ArrayList<Car>();
    }

    public int GetMaxSize() {
        return maxSize;
    }

    public int GetCurrentSize() {
        return cars.size();
    }

    public Car[] GetCars() {
        return cars.toArray(new Car[0]);
    }

    public void MoveCars(Vector2D position) {
        for(Car car : cars) {
            car.MoveToPosition(position);
        }
    }

    public void Load(Car car, Vector2D carLoaderPosition) {
        if(!cars.contains(car) && 
            cars.size() < maxSize && 
            Vector2D.Distance(car.GetCurrentPosition(), carLoaderPosition) <= maxLoadingDistance) {
                cars.add(car);
        }
    }

    public Car Unload(int index) {
        if(index < cars.size())
            return cars.remove(index);
        
        return null;
    }
}
