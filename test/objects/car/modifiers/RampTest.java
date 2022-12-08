package objects.car.modifiers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RampTest {
    Ramp ramp;
    final int currentAngle = 50;
    final int minAngle = 0;
    final int maxAngle = 90;


    @BeforeEach
    public void Init() {
        ramp = new Ramp(currentAngle, minAngle, maxAngle);
    }

    @Test
    public void TestClampMax() {
        int expected = maxAngle;

        ramp.Raise(maxAngle * 2);

        assertEquals(ramp.GetAngle(), expected);
    }

    @Test
    public void TestClampMin() {
        int expected = minAngle;

        ramp.Lower(maxAngle * 2);

        assertEquals(ramp.GetAngle(), expected);
    }
}
