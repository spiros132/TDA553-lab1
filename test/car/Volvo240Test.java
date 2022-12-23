package car;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Volvo240Test {
    Volvo240 volvo;

    @BeforeEach
    public void Init() {
        volvo = new Volvo240();
    }

    @Test
    public void VolvoMoveWith50PercentGas() {
        volvo.StartEngine();
        volvo.gas(0.5);
        volvo.Move();

        assertEquals(0.725, volvo.GetCurrentPosition().y, 0.01);
    }
}
