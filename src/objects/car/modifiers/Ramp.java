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


    public void Raise(int angle) {
        currentAngle += angle;

        currentAngle = Clamping.Clamp(currentAngle, minAngle, maxAngle);
    }

    public void Lower(int angle) {
        currentAngle -= angle;

        currentAngle = Clamping.Clamp(currentAngle, minAngle, maxAngle);
    }

    public int GetAngle() {
        return this.currentAngle;
    }

    public int GetMinAngle() {
        return this.minAngle;
    }

    public int GetMaxAngle() {
        return this.maxAngle;
    }
}
