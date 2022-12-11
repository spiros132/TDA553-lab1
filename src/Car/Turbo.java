package car;

public class Turbo {
    private Boolean turboOn;
    private double turboAmount;

    public Turbo(double turboAmount){
        turboOn = false;
        this.turboAmount = turboAmount;
    }

    public void turnOn() {
        turboOn = true;
    }

    public void turnOff() {
        turboOn = false;
    }

    public double getTurboAmount() {
        return turboOn ? turboAmount : 0;
    }
}