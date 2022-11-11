import java.awt.*;

public abstract class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    
    protected Vector2D position = new Vector2D();
    protected byte direction = 1; // 0 = Up, 1 = Right, 2 = Down, 3 = Left
    

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

    protected void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public abstract double speedFactor();

    protected abstract void incrementSpeed(double amount);

    protected abstract void decrementSpeed(double amount);

    
    Vector2D getDirection() {
        if(direction == 0) { // 0 is up
            return new Vector2D(0, 1);
        }
        else if(direction == 1) { // 1 is right
            return new Vector2D(1, 0);
        }
        else if(direction == 2) { // 2 is down
            return new Vector2D(0, -1);
        }
        else { // 3 is left
            return new Vector2D(-1, 0);
        }
    }

    public void move() {
        position = Vector2D.Add(position, Vector2D.Multiply(getDirection(), speedFactor()));
    }

    public void turnLeft() {
        direction -= 1;
        if (direction == -1); {
            direction = 3;
        }
    }

    public void turnRight() {
        direction += 1;
        if (direction == 4); {
            direction = 0;
        }
    }
}
