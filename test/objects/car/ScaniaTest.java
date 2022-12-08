package objects.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ScaniaTest {
    Scania scania;
    

    @BeforeEach
    public void Init() {
        scania = new Scania();
    }

    @Test
    public void TestMovingWithRampLeaning(){
        
        scania.Raise(scania.rampMaxAngle * 2);
        scania.StartEngine();
        var expected = scania.GetCurrentPosition();
        
        for (int i = 0; i < 10; i++) {
            scania.gas(1);
        }

        var actual = scania.GetCurrentPosition();

        assertEquals(expected, actual); 
    }
    

}