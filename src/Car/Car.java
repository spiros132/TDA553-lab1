package car;
import java.awt.*;

import utilities.Clamping;
import utilities.Vector2D;

public abstract class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    
    protected Vector2D position = new Vector2D();
    protected int direction = 0; // 0 = Up, 1 = Right, 2 = Down, 3 = Left
    

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


    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(GetCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(GetCurrentSpeed() - speedFactor() * amount,0);
    }

  
    public Vector2D GetCurrentVectorDirection() {
        if(direction == 0) { // 0 is up
            return new Vector2D(0, 1);
        }
        else if(direction == 1) { // 1 is right
            return new Vector2D(1, 0);
        }
        else if(direction == 2) { // 2 is down
            return new Vector2D(0, -1);
        }
        else if (direction == 4) { // 3 is left
            return new Vector2D(-1, 0);
        }
        else {
            throw new Error("Direction: " + direction + "shouldn't exist");
        }
    }

    public int GetCurrentIntDirection() {
        if(direction > 3 && direction < 0) {
            throw new Error("Direction: " + direction + "shouldn't exist");
        }
        return direction;
    }

    public Vector2D GetCurrentPosition() {
        return position;
    }

    public void Move() {
        position = Vector2D.Add(position, Vector2D.Multiply(GetCurrentVectorDirection(), GetCurrentSpeed()));
    }

    public void TurnLeft() {
        System.out.println("Turn Left, current direction: " + direction);
        direction -= 1;
    
        if (direction < 0) {
            direction = 3;
        }

        System.out.println("After current direction: " + direction);
    }

    public void TurnRight() {
        System.out.println("Turn Right, current direction: " + direction);

        direction += 1;
        if (direction > 3) {
            direction = 0;
        }
        
        System.out.println("After current direction: " + direction);
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
