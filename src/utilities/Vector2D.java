package utilities;

import java.lang.Override;

public class Vector2D {
    public double x;
    public double y;

    public static final Vector2D Zero = new Vector2D(0, 0);

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public static Vector2D add(Vector2D a, Vector2D b) {
        return new Vector2D(a.x + b.x, a.y + b.y);
    }

    public static Vector2D multiply(Vector2D a, double multiplier) {
        return new Vector2D(a.x * multiplier, a.y * multiplier);
    }

    public static double distance(Vector2D a, Vector2D b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared to itself then return true
        if(o == this) {
            return true;
        }

        // Return false if comparing to another type of object
        if(!(o instanceof Vector2D)) {
            return false;
        }

        Vector2D vector = (Vector2D)o;

        if(vector.x == this.x && vector.y == this.y) {
            return true;
        }

        return false;
    }

    public String toString() {
        return "X: " + x + "; Y: " + y + ";";
    }
}
