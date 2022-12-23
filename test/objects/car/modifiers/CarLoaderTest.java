package objects.car.modifiers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import objects.car.Car;
import objects.car.TestingCar;
import utilities.Vector2D;
import java.util.Random;

public class CarLoaderTest {
    CarLoader carLoader;
    final int maxSize = 10;

    @BeforeEach
    public void Init() {
        carLoader = new CarLoader(maxSize, 100);
    }

    @Test
    public void TestAddOverflow() {
        for (int i = 0; i < maxSize * 2; i++) {
            carLoader.load(new TestingCar(), Vector2D.Zero);
        }
        int expected = maxSize;
        int actual = carLoader.cars.size();

        assertEquals(expected, actual);
    }

    @Test
    public void TestUnloadCarsNull() {
        Car expected = null;
        Car actual = carLoader.unload(maxSize * 10);

        assertEquals(expected, actual);
    }
    
    @Test
    public void TestMoveCars() {
        Random random = new Random();
        TestingCar testCar = new TestingCar();
        Vector2D moveToPosition = new Vector2D(
            random.nextInt(1,100), 
            random.nextInt(1,100)
        );
        
        carLoader.load(testCar, Vector2D.Zero);
        carLoader.moveCars(moveToPosition);

        Vector2D expected = moveToPosition;
        Vector2D actual = testCar.getCurrentPosition();

        assertEquals(expected, actual);
    }
}
