package objects.car.modifiers;

public class Turbo {
    private Boolean turboOn;
    private double turboAmount;

    public Turbo(double turboAmount){
        turboOn = false;
        this.turboAmount = turboAmount;
    }

    public void TurnOn() {
        turboOn = true;
    }

    public void TurnOff() {
        turboOn = false;
    }

    public double GetTurboAmount() {
        return turboOn ? turboAmount : 0;
    }
}