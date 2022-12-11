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

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return cars.size();
    }

    public Car[] getCars() {
        return cars.toArray(new Car[0]);
    }

    public void moveCars(Vector2D position) {
        for(Car car : cars) {
            car.moveToPosition(position);
        }
    }

    public void load(Car car, Vector2D carLoaderPosition) {
        if(!cars.contains(car) && 
            cars.size() < maxSize && 
            Vector2D.distance(car.getCurrentPosition(), carLoaderPosition) <= maxLoadingDistance) {
                cars.add(car);
        }
    }

    public Car unload(int index) {
        if(index < cars.size())
            return cars.remove(index);
        
        return null;
    }
}
