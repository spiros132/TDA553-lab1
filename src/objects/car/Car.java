package objects.car;
import java.awt.*;

import objects.GameObject;
import utilities.Clamping;
import utilities.Vector2D;

public abstract class Car extends GameObject implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    
    public int GetNrDoors(){
        return nrDoors;
    }
    public double GetEnginePower(){
        return enginePower;
    }

    public double GetCurrentSpeed(){
        return currentSpeed;
    }

    public Color GetColor(){
        return color;
    }

    protected void setColor(Color clr){
	    color = clr;
    }

    public void StartEngine(){
        
	    currentSpeed = 0.1;
    }

    public void StopEngine(){
	    currentSpeed = 0;
    }


    protected abstract double speedFactor();
    
    protected boolean canDrive() {
        return true;
    }

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(GetCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(GetCurrentSpeed() - speedFactor() * amount,0);
    }

    public void TurnLeft() {
        if(GetCurrentSpeed() <= 0)
            return;

        RotateLeft(1);  
    }

    public void TurnRight() {
        if(GetCurrentSpeed() <= 0)
            return;

        RotateRight(1);
    }

    public void Move() {
        if (canDrive() == true)
            MoveWithDirection(Vector2D.Multiply(GetCurrentVectorDirection(), GetCurrentSpeed()));
    }

    public void gas(double amount){
        amount = Clamping.Clamp(amount, 0, 1);

        incrementSpeed(amount);
        
        currentSpeed = Clamping.Clamp(currentSpeed, 0, enginePower);
    }

    public void brake(double amount){
        amount = Clamping.Clamp(amount, 0, 1);

        decrementSpeed(amount);

        currentSpeed = Clamping.Clamp(currentSpeed, 0, enginePower);
    }
}
