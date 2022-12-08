package objects.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Vector2D;


public class CarTransporterTest {
    CarTransporter carTransporter;

    @BeforeEach
    public void Init() {
        carTransporter = new CarTransporter();
    }

   @Test
   public void TestDrivingWhileLoading() {
        carTransporter.Lower();
        carTransporter.StartEngine();

        var expected = carTransporter.GetCurrentPosition();
        
        for (int i = 0; i < 10; i++) {
            carTransporter.gas(1);
        }

        var actual = carTransporter.GetCurrentPosition();

        assertEquals(expected, actual);
   }

    @Test
    public void TestLoadCarTooFarAway() {
        TestingCar testcar = new TestingCar();
        
        var expected = carTransporter.GetCars();
        // Move testcar very far away by adding the cartransporters current position to a vector2D of a very big size
        testcar.MoveToPosition(Vector2D.Add(carTransporter.GetCurrentPosition(),new Vector2D(10000,10000) ));
        
        carTransporter.Load(testcar);
        var actual = carTransporter.GetCars();
        
        assertArrayEquals(expected, actual);

    }
   
}

