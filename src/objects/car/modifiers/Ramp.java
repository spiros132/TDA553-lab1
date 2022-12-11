package objects.car.modifiers;

import utilities.Clamping;

public class Ramp {
    private int currentAngle;
    private int maxAngle;
    private int minAngle;

    public Ramp(int startingAngle, int minAngle, int maxAngle) {
        currentAngle = startingAngle;
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;
    }


    public void raise(int angle) {
        currentAngle += angle;

        currentAngle = Clamping.clamp(currentAngle, minAngle, maxAngle);
    }

    public void lower(int angle) {
        currentAngle -= angle;

        currentAngle = Clamping.clamp(currentAngle, minAngle, maxAngle);
    }

    public int getAngle() {
        return this.currentAngle;
    }

    public int getMinAngle() {
        return this.minAngle;
    }

    public int getMaxAngle() {
        return this.maxAngle;
    }
}
