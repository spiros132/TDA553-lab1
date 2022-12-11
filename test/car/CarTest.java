package car;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Vector2D;

public class CarTest {
    Car car;

    @BeforeEach
    public void init() {
        car = new TestCar();
    }
    
    @Test
    public void TestLeftDirection(){
        int expectedDirection = car.getCurrentIntDirection() - 1;
        
        if(expectedDirection < 0) {
            expectedDirection = 3;
        }

        car.turnLeft();
        assertEquals(expectedDirection, car.getCurrentIntDirection());

    }

    @Test
    public void TestRightDirection() {
        int expectedDirection = car.getCurrentIntDirection() + 1;
     
        if(expectedDirection > 3) {
            expectedDirection = 0;
        }

        car.turnRight();
        assertEquals(expectedDirection, car.getCurrentIntDirection());
    }

    @Test
    public void TestMovement() {
        Vector2D expectedPosition = 
            Vector2D.add(car.getCurrentPosition(), 
                Vector2D.multiply(
                    car.getCurrentVectorDirection(), 
                    car.speedFactor()));

        car.move();
        assertEquals(expectedPosition, car.getCurrentPosition());
    }

    // Testing that clamp and gas work
    @Test
    public void TestClampIncrementSpeed() {
        // Start the engine
        car.startEngine();

        for (int i = 0; i < 10000; i++) {
            car.gas(1000000000);
        }

        // Check if the max the car can go is equal to the engine power
        assertTrue(car.getEnginePower() == car.getCurrentSpeed());
    }

    @Test
    public void TestClampDecreaseSpeed() {
        // Start the engine
        car.startEngine();

        for (int i = 0; i < 10000; i++) {
            car.brake(1000000000);
        }

        // Check if the min the car can go is equal to 0
        assertTrue(0 == car.getCurrentSpeed());
    }
}

