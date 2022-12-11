package objects.car.modifiers;

public class Trim {
    private double trimFactor;

    public Trim(double trimFactor) {
        this.trimFactor = trimFactor;
    }

    public double getTrimFactor() {
        return trimFactor;
    }
}