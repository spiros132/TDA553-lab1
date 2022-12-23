package car;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Vector2D;


public class Saab95Test {
    Saab95 saab;

    @BeforeEach
    public void Init() {
        saab = new Saab95();
    }

    @Test
    public void SaabMoveWith50PercentGas() {
        saab.StartEngine();
        saab.gas(0.5);
        saab.Move();

        assertEquals(0.725, saab.GetCurrentPosition().y, 0.01);
    }
}