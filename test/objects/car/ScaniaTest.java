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
        
        scania.raise(scania.rampMaxAngle * 2);
        scania.startEngine();
        var expected = scania.getCurrentPosition();
        
        for (int i = 0; i < 10; i++) {
            scania.gas(1);
        }

        var actual = scania.getCurrentPosition();

        assertEquals(expected, actual); 
    }
    

}