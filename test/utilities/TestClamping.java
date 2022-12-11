package utilities;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class TestClamping {
    // UPPER LIMITS //
    @Test
    public void TestUpperLimitInt() {
        int expectation = 100;

        int actual = Clamping.clamp(expectation * 2, -expectation, expectation);

        assertTrue(expectation == actual);
    }

    @Test
    public void TestUpperLimitFloat() {
        float expectation = 100.1564f;

        float actual = Clamping.clamp(expectation * 2, -expectation, expectation);

        assertTrue(expectation == actual);
    }

    @Test
    public void TestUpperLimitDouble() {
        double expectation = 100.0475d;

        double actual = Clamping.clamp(expectation * 2, -expectation, expectation);

        assertTrue(expectation == actual);
    }

    // LOWER LIMITS //
    @Test
    public void TestLowerLimitInt() {
        int expectation = 100;

        int actual = Clamping.clamp(-expectation * 2, -expectation, expectation);

        assertTrue(-expectation == actual);
    }

    @Test
    public void TestLowerLimitFloat() {
        float expectation = 100.1564f;

        float actual = Clamping.clamp(-expectation * 2, -expectation, expectation);

        assertTrue(-expectation == actual);
    }

    @Test
    public void TestLowerLimitDouble() {
        double expectation = 100.0475d;

        double actual = Clamping.clamp(-expectation * 2, -expectation, expectation);

        assertTrue(-expectation == actual);
    }
}
