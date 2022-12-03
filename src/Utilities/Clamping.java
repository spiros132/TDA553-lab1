package utilities;

public final class Clamping {
    // Clamp //
    public static double Clamp(double value, double min, double max) {
        if(value > max) {
            value = max;
        }

        if(value < min) {
            value = min;
        }

        return value;
    }

    public static int Clamp(int value, int min, int max) {
        if(value > max) {
            value = max;
        }

        if(value < min) {
            value = min;
        }

        return value;
    }

    public static float Clamp(float value, float min, float max) {
        if(value > max) {
            value = max;
        }

        if(value < min) {
            value = min;
        }

        return value;
    }
}
