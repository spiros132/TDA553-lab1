package objects;

import java.util.UUID;
import java.lang.Math;
import java.awt.image.BufferedImage;

import utilities.Vector2D;

public class GameObject {
    UUID uid;

    private Vector2D position = Vector2D.Zero;
    private int direction = 0; // 0 = Up, 1 = Right, 2 = Down, 3 = Left
    private BufferedImage gameObjectImage;

    public GameObject() {
        uid = UUID.randomUUID();
    }

    // Get / Set the image of the game object 
    public BufferedImage GetGameObjectImage() {
        return gameObjectImage;
    }

    protected void setGameObjectImage(BufferedImage image) {
        gameObjectImage = image;
    }
    // Set at cars staring porition and direction
    public void setStartingValues(Vector2D StartingPosition, int StartingDirection) {
        position = StartingPosition;
        direction = StartingDirection;
    }
    // Get current Vector2D direction
    public Vector2D getCurrentVectorDirection() {
        if(direction == 0) { // 0 is up
            return new Vector2D(0, 1);
        }
        else if(direction == 1) { // 1 is right
            return new Vector2D(1, 0);
        }
        else if(direction == 2) { // 2 is down
            return new Vector2D(0, -1);
        }
        else if (direction == 3) { // 3 is left
            return new Vector2D(-1, 0);
        }
        else {
            throw new Error("Direction: " + direction + "shouldn't exist");
        }
    }
    // Get current int direction
    public int getCurrentIntDirection() {
        if(direction > 3 && direction < 0) {
            throw new Error("Direction: " + direction + "shouldn't exist");
        }
        return direction;
    }

    public Vector2D getCurrentPosition() {
        return position;
    }

    // Moves car to position
    public void moveToPosition(Vector2D position) {
        this.position = position;
    }

    // Moves car in a direction
    protected void moveWithDirection(Vector2D direction) {
        this.position = Vector2D.add(this.position, direction);
    }

    // Rotate car a certain steps
    protected void rotateRight(int stepsAmount) {
        direction += stepsAmount;
        direction = Math.floorMod(direction, 4);
    }

    protected void rotateLeft(int stepsAmount) {
        direction -= stepsAmount;
        direction = Math.floorMod(direction, 4);
    }

    public void update() {
        // Implement for each gameobject in itself
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared to itself then return true
        if(o == this) {
            return true;
        }

        // Return false if comparing to another type of object
        if(!(o instanceof GameObject)) {
            return false;
        }

        GameObject gameObject = (GameObject)o;

        if(gameObject.uid == this.uid) {
            return true;
        }

        return false;
    }
}
