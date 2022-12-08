package objects;

import java.util.UUID;

import utilities.Vector2D;

public class GameObject {
    UUID uid;

    protected Vector2D position = new Vector2D();
    protected int direction = 1; // 0 = Up, 1 = Right, 2 = Down, 3 = Left

    public GameObject() {
        uid = UUID.randomUUID();
    }

    public Vector2D GetCurrentVectorDirection() {
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

    public int GetCurrentIntDirection() {
        if(direction > 3 && direction < 0) {
            throw new Error("Direction: " + direction + "shouldn't exist");
        }
        return direction;
    }

    public Vector2D GetCurrentPosition() {
        return position;
    }

    public void MoveToPosition(Vector2D position) {
        this.position = position;
    }

    protected void MoveWithDirection(Vector2D direction) {
        position = Vector2D.Add(position, direction);
    }

    protected void RotateRight(int stepsAmount) {
        direction = (direction + stepsAmount) % 4;
    }

    protected void RotateLeft(int stepsAmount) {
        direction = (direction - stepsAmount) % 4;
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
