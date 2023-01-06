package objects.car;
import java.awt.*;

import objects.GameObject;
import utilities.Clamping;
import utilities.Vector2D;

public abstract class Car extends GameObject implements IMovable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private double currentSpeed; // The current speed of the car
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr) {
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    protected abstract double speedFactor();
    
    protected boolean canDrive() {
        return true;
    }

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void turnLeft() {
        rotateLeft(1);  
    }

    public void turnRight() {
        rotateRight(1);
    }
    
    public void move() {
        if (canDrive())
            moveWithDirection(Vector2D.multiply(getCurrentVectorDirection(), getCurrentSpeed()));
    }

    public void gas(double amount){
        System.out.println("Gas attempted");
        amount = Clamping.clamp(amount, 0, 1);

        incrementSpeed(amount);

        currentSpeed = Clamping.clamp(currentSpeed, 0, enginePower);
    }

    public void brake(double amount){
        amount = Clamping.clamp(amount, 0, 1);

        decrementSpeed(amount);

        currentSpeed = Clamping.clamp(currentSpeed, 0, enginePower);
    }

    @Override
    public void update() {
        move();
    }
}
