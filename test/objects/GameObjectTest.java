package objects;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import utilities.Vector2D;

public class GameObjectTest {
    GameObject gameObject;

    Random random = new Random();

    
    @BeforeEach
    public void Init() {
        gameObject = new GameObject();
    }

    @Test
    public void TrySetStartingValues() {
        // Instantiate variables
        Vector2D position = getRandomVector();
        int direction = random.nextInt(0, 3);

        // Set starting values
        gameObject.setStartingValues(position, direction);

        // Assert equals for both position and direction
        assertEquals(position, gameObject.getCurrentPosition());
        assertEquals(direction, gameObject.getCurrentIntDirection());
    }

    @Test
    public void TryMoveToPosition() {
        // Instantiate variables
        Vector2D position = getRandomVector();

        // Move gameObject to a position
        gameObject.moveToPosition(position);

        // Assert equals
        assertEquals(position, gameObject.getCurrentPosition());
    }

    @Test
    public void TryMoveToDirection() {
        // Instantiate variables
        Vector2D position = getRandomVector();
        Vector2D direction = getRandomVector();

        // Expected value
        Vector2D expected = Vector2D.add(position, direction);
        // Set starting position
        gameObject.setStartingValues(position, 0);
        // Move with a direction
        gameObject.moveWithDirection(direction);

        // Assert Equals
        assertEquals(expected, gameObject.getCurrentPosition());
    }

    @Test
    public void TryRotateRight() {
        int startingRotation = 0;
        int expectedRotation = 1;
        gameObject.setStartingValues(getRandomVector(), startingRotation);

        // Rotate 1 step
        gameObject.rotateRight(1);
        assertEquals(expectedRotation, gameObject.getCurrentIntDirection());

        // Rotate 4 steps
        gameObject.rotateRight(4);
        assertEquals(expectedRotation, gameObject.getCurrentIntDirection());
    }

    @Test
    public void TryRotateLeft() {
        int startingRotation = 0;
        int expectedRotation = 3;
        gameObject.setStartingValues(getRandomVector(), startingRotation);

        // Rotate 1 step
        gameObject.rotateLeft(1);
        assertEquals(expectedRotation, gameObject.getCurrentIntDirection());

        // Rotate 4 steps
        gameObject.rotateLeft(4);
        assertEquals(expectedRotation, gameObject.getCurrentIntDirection());
    }

    Vector2D getRandomVector() {
        Random random = new Random();
        return new Vector2D(
            random.nextDouble(-1000, 1000),
            random.nextDouble(-1000, 1000)
        );
    }
}
