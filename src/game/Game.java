package game;

import game.controlPanel.ControlPanel;
import objects.GameObject;
import objects.car.*;
import objects.car.modifiers.*;
import utilities.Vector2D;

import java.util.ArrayList;

public class Game {
    ControlPanel controlPanel;
    
    int gasAmount;
    
    ArrayList<GameObject> gameObjects = new ArrayList<>();

    public Game() {
        controlPanel = new ControlPanel(this);

        // Create new cars and set the starting values
        Saab95 saab = new Saab95();
        saab.setStartingValues(Vector2D.Zero, 1);

        Volvo240 volvo = new Volvo240();
        volvo.setStartingValues(new Vector2D(0, 200), 1);
        
        Scania scania = new Scania();
        scania.setStartingValues(new Vector2D(0,400), 1);
        
        // Add them to the gameobjects list
        gameObjects.add(saab);
        gameObjects.add(volvo);
        gameObjects.add(scania);
    }

    public GameObject[] GetGameObjects() {
        return gameObjects.toArray(new GameObject[0]);
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }


    // Call gas on all cars
    public void gas() {
        for (GameObject gameObject : gameObjects) {
            Car c = GetCar(gameObject);

            if(c != null) {
                c.gas(getGasAmount());
            }
        }
    }

    // Call brake on all cars
    public void brake() {
        for (GameObject gameObject : gameObjects) {
            Car c = GetCar(gameObject);

            if(c != null) {
                c.brake(getGasAmount());
            }
        }
    }


    // Turn turbo on, on all objects that have the IHasTurbo interface
    public void turboOn() {
         for (GameObject gameObject : gameObjects) {
            IHasTurbo t = GetIHasTurbo(gameObject);

            if(t != null) {
                t.setTurboOn();
            } 
        }
    }

    // Turn turbo off, on all objects that have the IHasTurbo interface
    public void turboOff() {
         for (GameObject gameObject : gameObjects) {
            IHasTurbo t = GetIHasTurbo(gameObject);

            if(t != null) {
                t.setTurboOff();
            } 
        }
    }


    // Lower the ramp on all objects that have a ramp
    public void lowerBed() {
        for (GameObject gameObject : gameObjects) {
            IHasRamp r = GetIHasRamp(gameObject);

            if(r != null) {
                r.lower(99999);
            }
        }
    }
    
    // Raise the ramp on all objects that have a ramp
    public void liftBed() {
        for (GameObject gameObject : gameObjects) {
            IHasRamp r = GetIHasRamp(gameObject);

            if(r != null) {
                r.raise(99999);
            }
        }
    }

    // Return the gas amount in the appropriate form
    public double getGasAmount() {
        return (double)gasAmount / 100d;
    }
    // Set the gas amount
    public void setGasAmount(int gasAmount) {
       this.gasAmount = gasAmount;
    }


    // Start all engines on all cars
    public void startAllEngines() {
        System.out.println("Starting All Engines");
        for (GameObject gameObject : gameObjects) {
            Car c = GetCar(gameObject);

            if(c != null) {
                c.startEngine();
            }
        }
    }

    // Stop all engines on all cars
    public void stopAllEngines(){
        for (GameObject gameObject : gameObjects) {
            Car c = GetCar(gameObject);

            if(c != null) {
                c.stopEngine();
            }
        }
    }

    // HELPER FUNCTIONS //
    // Helper function to downcast to the Car class
    private Car GetCar(GameObject gameObject) {
        if(gameObject instanceof Car) {
            return (Car)gameObject;
        }

        return null;
    }

    // Helper function to downcast to the IHasTurbo interface
    private IHasTurbo GetIHasTurbo(GameObject gameObject) {
        if(gameObject instanceof IHasTurbo) {
            return (IHasTurbo)gameObject;
        }

        return null;
    }
    
    // Helper function to downcast to the IHasRamp interface
    private IHasRamp GetIHasRamp(GameObject gameObject) {
        if(gameObject instanceof IHasRamp) {
            return (IHasRamp)gameObject;
        }

        return null;
    }

    // GAME UPDATE FUNCTION //
    // Call update on all the gameobjects
    // Each gameobject contains the update logic for themselves
    public void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }
}
