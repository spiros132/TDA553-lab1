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
        carTransporter.lower(1);
        carTransporter.startEngine();

        var expected = carTransporter.getCurrentPosition();
        
        for (int i = 0; i < 10; i++) {
            carTransporter.gas(1);
        }

        var actual = carTransporter.getCurrentPosition();

        assertEquals(expected, actual);
   }

    @Test
    public void TestLoadCarTooFarAway() {
        TestingCar testcar = new TestingCar();
        
        var expected = carTransporter.getCars();
        // Move testcar very far away by adding the cartransporters current position to a vector2D of a very big size
        testcar.moveToPosition(Vector2D.add(carTransporter.getCurrentPosition(),new Vector2D(10000,10000) ));
        
        carTransporter.load(testcar);
        var actual = carTransporter.getCars();
        
        assertArrayEquals(expected, actual);

    }
   
}

