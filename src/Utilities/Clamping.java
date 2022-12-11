package utilities;

public final class Clamping {
    // Clamp //
    public static double clamp(double value, double min, double max) {
        if(value > max) {
            value = max;
        }

        if(value < min) {
            value = min;
        }

        return value;
    }

    public static int clamp(int value, int min, int max) {
        if(value > max) {
            value = max;
        }

        if(value < min) {
            value = min;
        }

        return value;
    }

    public static float clamp(float value, float min, float max) {
        if(value > max) {
            value = max;
        }

        if(value < min) {
            value = min;
        }

        return value;
    }
}
