public class Vector2D {
    public double x;
    public double y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public static Vector2D Add(Vector2D a, Vector2D b) {
        return new Vector2D(a.x + b.x, a.y + b.y);
    }

    public static Vector2D Multiply(Vector2D a, double multiplier) {
        return new Vector2D(a.x * multiplier, a.y * multiplier);
    }
}
