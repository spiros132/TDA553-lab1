package utilities;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class TestVector2D {
    Vector2D vec1 = new Vector2D(2, 5);
    Vector2D vec2 = new Vector2D(5, 2);

    @Test
    public void TestAdd() {
        var expectation = new Vector2D(vec1.x + vec2.x, vec1.y + vec2.y);
        var actual = Vector2D.Add(vec1, vec2);

        assertEquals(expectation, actual);
    }

    @Test
    public void TestMultiply() {
        int constant = 7;
        var expectation = new Vector2D(vec1.x * constant, vec1.y * constant);
        var actual = Vector2D.Multiply(vec1, constant);

        assertEquals(expectation, actual);
    }
}
